package org.geek.dcalculator.formater;

import org.geek.dcalculator.CalculatorRule;
import org.triple.common.extension.SPI;

@SPI("java")
public interface CalculatorFormater {
	public String format(CalculatorRule calculatorRule);

}
