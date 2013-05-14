package org.geek.dynamicc.formater.impl;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.AbstractBooleanFormater;

public class SQLFormater extends AbstractBooleanFormater {

	public SQLFormater() {
		initMap();
	}

	protected void initMap() {

		operatorsMap.put(0, " = ");
		operatorsMap.put(1, " != ");
		operatorsMap.put(2, " > ");
		operatorsMap.put(3, " < ");
		operatorsMap.put(4, " >= ");
		operatorsMap.put(5, " <= ");

		linkMap.put(0, "");
		linkMap.put(1, Constants.LINK_AND_SQL);
		linkMap.put(2, Constants.LINK_OR_SQL);
	}

	@Override
	protected Object doFormat(BooleanUnit<?> booleanUnit) {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(booleanUnit.getCalculatorUnit().getUnitName());
		strBuffer.append(operatorsMap.get(booleanUnit.getLogicMark()));
		strBuffer.append(booleanUnit.getKeyValue());
		strBuffer.append(linkMap.get(booleanUnit.getLink()));

		return strBuffer.toString();
	}
}
