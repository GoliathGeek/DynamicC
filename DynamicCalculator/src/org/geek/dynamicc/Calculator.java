package org.geek.dynamicc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Calculator implements Serializable {
	private String id;
	private String name;
	private String func;
	private String sign;

	private List<Calculator> childCalculator = new ArrayList<Calculator>();
	private List<CalculatorUnit> units = new ArrayList<CalculatorUnit>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<CalculatorUnit> getUnits() {
		return units;
	}
	public void setUnits(List<CalculatorUnit> units) {
		this.units = units;
	}
	public List<Calculator> getChildCalculator() {
		return childCalculator;
	}
	public void setChildCalculator(List<Calculator> childCalculator) {
		this.childCalculator = childCalculator;
	}
	
	
}
