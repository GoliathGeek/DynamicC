package org.geek.dynamicc.formater.impl;

import java.util.HashSet;

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

		linkMap.put(1, Constants.LINK_AND_SQL);
		linkMap.put(2, Constants.LINK_OR_SQL);
		linkMap.put(3, "+");
		linkMap.put(4, "-");
		linkMap.put(5, "*");
		linkMap.put(6, "/");
		linkSet = new HashSet<String>(linkMap.values());

	}

}
