package org.geek.dynamicc;

public interface Function {
	public Number invoke();

	public Expression[] getExpressions();

	public String getFuncName();
}
