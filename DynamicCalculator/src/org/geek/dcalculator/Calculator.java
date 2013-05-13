package org.geek.dcalculator;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Calculator<T extends Number> implements Serializable {

	private String id;
	private String calculatorName;
	// 计算单元
	private CalculatorUnit<T> calculatorUnit;

	// 连接符
	private int link;

	// 逻辑计算符
	private int logicMark;
	// 阀值
	private T keyValue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalculatorName() {
		return calculatorName;
	}

	public void setCalculatorName(String calculatorName) {
		this.calculatorName = calculatorName;
	}

	public CalculatorUnit<T> getCalculatorUnit() {
		return calculatorUnit;
	}

	public void setCalculatorUnit(CalculatorUnit<T> calculatorUnit) {
		this.calculatorUnit = calculatorUnit;
	}

	public T getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(T keyValue) {
		this.keyValue = keyValue;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public int getLogicMark() {
		return logicMark;
	}

	public void setLogicMark(int logicMark) {
		this.logicMark = logicMark;
	}

}
