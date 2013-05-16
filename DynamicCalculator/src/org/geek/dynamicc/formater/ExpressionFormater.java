package org.geek.dynamicc.formater;

import org.geek.dynamicc.Expression;
import org.triple.common.extension.SPI;

@SPI("java")
public interface ExpressionFormater {
	public String format(Expression expression);

}
