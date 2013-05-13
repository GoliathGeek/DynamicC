package org.geek.dcalculator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class CalculatorRule implements Serializable {
	private String id;
	private String name;
	// 连接符
	private int link;
	private List<Calculator<?>> calculators = new ArrayList<Calculator<?>>();
	private List<CalculatorRule> childRules = new ArrayList<CalculatorRule>();

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

	public List<CalculatorRule> getChildRules() {
		return childRules;
	}

	public void setChildRules(List<CalculatorRule> childRules) {
		this.childRules = childRules;
	}

	public List<Calculator<?>> getCalculators() {
		return calculators;
	}

	public void setCalculators(List<Calculator<?>> calculators) {
		this.calculators = calculators;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public void addChildRule(CalculatorRule childRule) {
		childRules.add(childRule);
	}
	
	public void addCalculator(Calculator<?> calculator) {
		calculators.add(calculator);
	}
}
