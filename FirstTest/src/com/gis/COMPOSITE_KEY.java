package com.gis;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class COMPOSITE_KEY implements Serializable {
	String NAME;
	String PHONE;
	String ADDRESS;
	/**
	 * @return the aDDRESS
	 */
	public String getADDRESS() {
		return ADDRESS;
	}

	/**
	 * @param aDDRESS the aDDRESS to set
	 */
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @param nAME the nAME to set
	 */
	public void setNAME(String nAME) {
		NAME = nAME;
	}

	/**
	 * @return the pHONE
	 */
	public String getPHONE() {
		return PHONE;
	}

	/**
	 * @param pHONE the pHONE to set
	 */
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	// 必須重新定義equals()與hashCode()
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof COMPOSITE_KEY)) {
			return false;
		}
		COMPOSITE_KEY item = (COMPOSITE_KEY) obj;
		return new EqualsBuilder().append(this.NAME, item.getNAME())
				.append(this.PHONE, item.getPHONE()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(this.NAME).append(this.NAME)
				.toHashCode();
	}
}
