package org.geek.dynamicc;

import org.triple.common.extension.SPI;

@SPI
public interface Function {
	public Number invoke();

	public Expression[] getExpressions();
	
	public String getFuncName();
}
