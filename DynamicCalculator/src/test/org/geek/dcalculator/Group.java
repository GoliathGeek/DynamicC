package test.org.geek.dcalculator;

import java.io.Serializable;

import org.geek.dcalculator.CalculatorRule;
import org.geek.dcalculator.formater.CalculatorFormater;

@SuppressWarnings("serial")
public class Group implements Serializable {
	private String id;
	private String name;
	private CalculatorRule startCalculatorRule;
	private CalculatorFormater formater;

	public Group(String id, String name, CalculatorFormater formater) {
		this.id = id;
		this.name = name;
		this.formater = formater;
	}

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

	public CalculatorRule getStartCalculatorRule() {
		return startCalculatorRule;
	}

	public void setStartCalculatorRule(CalculatorRule startCalculatorRule) {
		this.startCalculatorRule = startCalculatorRule;
	}

	public String toString() {
		return "Group id:" + this.id + " name:" + name + "={" + this.formater.format(startCalculatorRule) + "}";
	}
}
