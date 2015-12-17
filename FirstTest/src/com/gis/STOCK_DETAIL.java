package com.gis;

public class STOCK_DETAIL {
	private int ID;
	private STOCK STOCK;
	private PRODUCT PRODUCT;
	private int QTY;

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the sTOCK
	 */
	public STOCK getSTOCK() {
		return STOCK;
	}

	/**
	 * @param sTOCK
	 *            the sTOCK to set
	 */
	public void setSTOCK(STOCK sTOCK) {
		STOCK = sTOCK;
	}

	/**
	 * @return the pRODUCT
	 */
	public PRODUCT getPRODUCT() {
		return PRODUCT;
	}

	/**
	 * @param pRODUCT
	 *            the pRODUCT to set
	 */
	public void setPRODUCT(PRODUCT pRODUCT) {
		PRODUCT = pRODUCT;
	}

	/**
	 * @return the qTY
	 */
	public int getQTY() {
		return QTY;
	}

	/**
	 * @param qTY
	 *            the qTY to set
	 */
	public void setQTY(int qTY) {
		QTY = qTY;
	}

}
