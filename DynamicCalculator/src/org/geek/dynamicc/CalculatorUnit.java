/**
 * 
 */
package org.geek.dynamicc;

import java.io.Serializable;

/**
 * TODO
 * @author Cxl
 * @createTime 2013-5-13 
 */
@SuppressWarnings("serial")
public class CalculatorUnit<T extends Number> implements Serializable {
	private String id;
	private String unitName;

	public CalculatorUnit(String unitName) {
		this.unitName = unitName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
