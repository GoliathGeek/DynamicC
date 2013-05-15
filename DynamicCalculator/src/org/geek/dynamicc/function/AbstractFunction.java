package org.geek.dynamicc.function;

import org.geek.dynamicc.Expression;
import org.geek.dynamicc.Function;

public abstract class AbstractFunction implements Function {

	private String funcName;
	private Expression[] expressions;

	public AbstractFunction(String funcName, Expression... expressions) {
		this.setFuncName(funcName);
		this.setExpressions(expressions);
	}

	@Override
	public Number invoke() {
		return 0;
	}

	public abstract Number doInvoke();

	@Override
	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	@Override
	public Expression[] getExpressions() {
		return expressions;
	}

	public void setExpressions(Expression[] expressions) {
		this.expressions = expressions;
	}
}
