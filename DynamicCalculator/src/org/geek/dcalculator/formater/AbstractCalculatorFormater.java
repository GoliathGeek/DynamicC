package org.geek.dcalculator.formater;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dcalculator.Calculator;
import org.geek.dcalculator.CalculatorRule;

public abstract class AbstractCalculatorFormater implements CalculatorFormater {

	protected static Map<Integer, String> linkMap = new HashMap<Integer, String>();
	protected static final Map<Integer, String> operatorsMap = new ConcurrentHashMap<Integer, String>();

	public String format(CalculatorRule calculatorRule) {
		StringBuffer strBuffer = new StringBuffer();
		if (calculatorRule.getChildRules().size() > 0) {
			StringBuffer strBufferTemp = new StringBuffer();
			for (CalculatorRule childRule : calculatorRule.getChildRules()) {
				String tempStr = format(childRule);
				if (tempStr.length() > 0) {
					strBufferTemp.append(tempStr);
					strBufferTemp.append(linkMap.get(childRule.getLink()));
				}
			}
			wipeEnd(strBufferTemp);
			if (strBufferTemp.length() > 0) {
				strBuffer.append(" ( " + strBufferTemp + " ) ");
				strBuffer.append(linkMap.get(calculatorRule.getLink()));
			}
		}
		if (calculatorRule.getCalculators().size() > 0) {
			for (Calculator<?> calculator : calculatorRule.getCalculators()) {
				strBuffer.append(doFormat(calculator));
			}
		}
		wipeEnd(strBuffer);
		return strBuffer.toString();
	}

	protected abstract Object doFormat(Calculator<?> calculator);

	protected abstract void wipeEnd(StringBuffer strBuffer);
}
