package com.gis.beans;

import java.util.List;

public class AreaBean {
private List<CityBean> _area;

public List <CityBean> getArea(){
		return _area;
}
public AreaBean (List<CityBean> area){
	_area=area;
}
}
