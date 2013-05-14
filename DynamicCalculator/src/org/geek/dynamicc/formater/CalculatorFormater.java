package org.geek.dynamicc.formater;

import org.geek.dynamicc.CalculatorRule;
import org.triple.common.extension.SPI;

@SPI("java")
public interface CalculatorFormater {
	public String format(CalculatorRule calculatorRule);

}
