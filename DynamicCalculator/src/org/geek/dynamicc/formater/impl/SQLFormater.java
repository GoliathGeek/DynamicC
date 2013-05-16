package org.geek.dynamicc.formater.impl;

import java.util.HashSet;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;
import org.geek.dynamicc.Function;
import org.geek.dynamicc.Unit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.AbstractExpressionFormater;

public class SQLFormater extends AbstractExpressionFormater {

	public SQLFormater() {
		initParams();
	}

	protected void initParams() {

		logicMarkMap.put(0, " = ");
		logicMarkMap.put(1, " != ");
		logicMarkMap.put(2, " > ");
		logicMarkMap.put(3, " < ");
		logicMarkMap.put(4, " >= ");
		logicMarkMap.put(5, " <= ");

		linkMap.put(1, Constants.LINK_AND_SQL);
		linkMap.put(2, Constants.LINK_OR_SQL);
		linkMap.put(3, "+");
		linkMap.put(4, "-");
		linkMap.put(5, "*");
		linkMap.put(6, "/");
		linkSet = new HashSet<String>(linkMap.values());

	}

	protected String doFormat(Unit unit) {
		StringBuffer strBuf = new StringBuffer();
		if (unit instanceof CalculatorUnit) {
			CalculatorUnit cUnit = (CalculatorUnit) unit;
			if (cUnit.getFunction() != null) {
				Function func = cUnit.getFunction();
				strBuf.append(func.getFuncName());
				strBuf.append("(");
				Expression[] expressions = func.getExpressions();
				if (expressions != null && expressions.length > 0) {
					StringBuffer tempStrBuffer = new StringBuffer();
					for (Expression expression : expressions) {
						tempStrBuffer.append(format(expression));
						tempStrBuffer.append(",");
					}
					if (tempStrBuffer.length() > 0) {
						tempStrBuffer.deleteCharAt(tempStrBuffer.length() - 1);
						strBuf.append(tempStrBuffer);
					}
				}
				strBuf.append(")");
			} else {
				if (cUnit.isConstantFlag()) {
					strBuf.append(cUnit.getConstant());
				} else {
					strBuf.append(cUnit.getName());

				}
			}
		} else if (unit instanceof BooleanUnit) {
			BooleanUnit bUnit = (BooleanUnit) unit;
			String strLeft = format(bUnit.getLeft());
			String strRight = format(bUnit.getRight());

			if (strLeft.length() > 0 && strRight.length() > 0) {
				strBuf.append(strLeft);
				strBuf.append(logicMarkMap.get(bUnit.getLogicMark()));
				strBuf.append(strRight);
			}
		}
		return strBuf.toString();
	}
}
