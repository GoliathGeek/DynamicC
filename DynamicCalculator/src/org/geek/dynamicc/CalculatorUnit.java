/**
 * 
 */
package org.geek.dynamicc;

@SuppressWarnings("serial")
public class CalculatorUnit extends Unit {
	public CalculatorUnit(String name) {
		super(name);
	}

	private boolean constantFlag = false;

	private Number constant;

	private Function function;

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Number getConstant() {
		return constant;
	}

	public void setConstant(Number constant) {
		this.constant = constant;
		this.setConstantFlag(true);
	}

	public boolean isConstantFlag() {
		return constantFlag;
	}

	public void setConstantFlag(boolean constantFlag) {
		this.constantFlag = constantFlag;
	}
}
