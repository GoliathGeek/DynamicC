package org.geek.dynamicc.formater;

import org.geek.dynamicc.BooleanExpression;
import org.triple.common.extension.SPI;

@SPI("java")
public interface BooleanFormater {
	public String format(BooleanExpression booleanExpression);

}
