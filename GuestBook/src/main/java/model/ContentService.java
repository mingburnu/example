package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.ContentDAOJdbc;

public class ContentService {
	private ContentDAO dao = new ContentDAOJdbc();
	public List<ContentBean> select(ContentBean bean) {
		List<ContentBean> result = null;
		if(bean!=null && bean.getTitle()!=null) {
			ContentBean temp = dao.select(bean.getTitle());
			if(temp!=null) {
				result = new ArrayList<ContentBean>();
				result.add(temp);
			}
		} else {
			result = dao.select(); 
		}
		return result;
	}
	public ContentBean insert(ContentBean bean) {
		ContentBean result = null;
		if(bean!=null) {
			result = dao.insert(bean);
		}
		return result;
	}
	public static void main(String[] args) {
		ContentService service = new ContentService();
		List<ContentBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
