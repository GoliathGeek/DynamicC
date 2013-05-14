package org.geek.dynamicc.formater.impl;

import org.geek.dynamicc.Calculator;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.AbstractCalculatorFormater;

public class SQLFormater extends AbstractCalculatorFormater {

	static {
		operatorsMap.put(0, " = ");
		operatorsMap.put(1, " != ");
		operatorsMap.put(2, " > ");
		operatorsMap.put(3, " < ");
		operatorsMap.put(4, " >= ");
		operatorsMap.put(5, " <= ");
	}
	static {
		linkMap.put(0, "");
		linkMap.put(1, Constants.LINK_AND_SQL);
		linkMap.put(2, Constants.LINK_OR_SQL);
	}

	@Override
	protected void wipeEnd(StringBuffer strBuffer) {
		String endStr;
		if (strBuffer.length() >= Constants.LINK_AND_SQL.length()) {
			endStr = strBuffer.substring(strBuffer.length() - Constants.LINK_AND_SQL.length(), strBuffer.length());
			if (endStr.endsWith(Constants.LINK_AND_SQL)) {
				strBuffer.delete(strBuffer.length() - Constants.LINK_AND_SQL.length(), strBuffer.length());
			}
		}

		if (strBuffer.length() >= Constants.LINK_OR_SQL.length()) {
			endStr = strBuffer.substring(strBuffer.length() - Constants.LINK_OR_SQL.length(), strBuffer.length());
			if (endStr.endsWith(Constants.LINK_OR_SQL)) {
				strBuffer.delete(strBuffer.length() - Constants.LINK_OR_SQL.length(), strBuffer.length());
			}
		}

	}

	@Override
	protected Object doFormat(Calculator<?> calculator) {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(calculator.getCalculatorUnit().getUnitName());
		strBuffer.append(operatorsMap.get(calculator.getLogicMark()));
		strBuffer.append(calculator.getKeyValue());
		strBuffer.append(linkMap.get(calculator.getLink()));

		return strBuffer.toString();
	}
}
