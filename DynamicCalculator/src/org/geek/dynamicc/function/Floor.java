package org.geek.dynamicc.function;

import org.geek.dynamicc.Expression;

public class Floor extends AbstractFunction {

	public Floor(Expression... params) {
		super("floor", params);
	}

	@Override
	public Number doInvoke() {
		return null;
	}

}
