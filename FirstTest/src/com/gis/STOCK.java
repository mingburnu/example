package com.gis;

import java.util.HashSet;
import java.util.Set;

public class STOCK {
	private int ID;
	private Set<STOCK_DETAIL> DETAILS;
	private String LOCATION;
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the lOCATION
	 */
	public String getLOCATION() {
		return LOCATION;
	}
	/**
	 * @param lOCATION the lOCATION to set
	 */
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	/**
	 * @return the dETAILS
	 */
	public Set<STOCK_DETAIL> getDETAILS() {
		return DETAILS;
	}
	/**
	 * @param dETAILS the dETAILS to set
	 */
	public void setDETAILS(Set<STOCK_DETAIL> dETAILS) {
		DETAILS = dETAILS;
	}
	public void addDETAIL(STOCK_DETAIL value){
		DETAILS.add(value);
	}
	public void removeDETAIL(STOCK_DETAIL value){
		DETAILS.remove(value);
	}
	public STOCK(){
		DETAILS = new HashSet();
	}
}
