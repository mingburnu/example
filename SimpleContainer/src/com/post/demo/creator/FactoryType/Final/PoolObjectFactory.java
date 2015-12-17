package com.post.demo.creator.FactoryType.Final;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.utils.ObjectFactory;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class PoolObjectFactory extends ObjectFactory {
	class PoolData {
		public boolean InUse = false;
		public Object obj;
	}

	@SuppressWarnings("rawtypes")
	private List _storage;
	private int _max = 100;
	private boolean _limit = false;

	public PoolObjectFactory(int max, boolean limit, List storage) {
		_max = max;
		_limit = limit;
		_storage = storage;
	}

	@SuppressWarnings("rawtypes")
	PoolObjectFactory() {
		_storage = new ArrayList();
	}

	private synchronized PoolData getPoolData(Object obj) {

		{
			for (int i = 0; i < _storage.size(); i++) {
				PoolData p = (PoolData) _storage.get(i);
				if (p.obj == obj)
					return p;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private synchronized Object GetObject(String className) throws Exception {
		for (int i = 0; i < _storage.size(); i++) {
			PoolData p = (PoolData) _storage.get(i);
			if (!p.InUse) {
				p.InUse = true;
				return p.obj;
			}
		}
		if (_storage.size() > _max && _limit)
			throw new Exception("max limit is arrived.");
		Object obj = Class.forName(className).newInstance();
		PoolData p1 = new PoolData();
		p1.InUse = true;
		p1.obj = obj;
		_storage.add(p1);
		return obj;
	}

	private void PutObject(Object obj) {
		PoolData p = getPoolData(obj);
		if (p != null)
			p.InUse = false;
	}

	public Object createInstance(String className) {
		try {
			return GetObject(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
public void Release(Object obj){
	if(_storage.size()> _max){
		PoolData p=getPoolData(obj);
		_storage.remove(p);
		return;
	}
	PutObject(obj);
}
}
