package org.geek.dynamicc.formater.impl;

import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Unit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.AbstractExpressionFormater;

public class SQLFormater extends AbstractExpressionFormater {

	public SQLFormater() {
		initParams();
	}

	protected void initParams() {

		operatorsMap.put(0, " = ");
		operatorsMap.put(1, " != ");
		operatorsMap.put(2, " > ");
		operatorsMap.put(3, " < ");
		operatorsMap.put(4, " >= ");
		operatorsMap.put(5, " <= ");

		linkMap.put(0, "");
		linkMap.put(1, Constants.LINK_AND_SQL);
		linkMap.put(2, Constants.LINK_OR_SQL);
		linkMap.put(3, "+");
		linkMap.put(4, "-");
		linkMap.put(5, "*");
		linkMap.put(6, "/");
	}

	@Override
	protected String doFormat(Unit unit) {
		StringBuffer strBuf = new StringBuffer();
		if (unit instanceof CalculatorUnit) {
			CalculatorUnit cUnit = (CalculatorUnit) unit;
			strBuf.append(cUnit.getName());
		}
		return strBuf.toString();
	}
}
