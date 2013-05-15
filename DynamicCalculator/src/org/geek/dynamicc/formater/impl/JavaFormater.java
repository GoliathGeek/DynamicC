package org.geek.dynamicc.formater.impl;

import java.util.HashSet;

import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;
import org.geek.dynamicc.Function;
import org.geek.dynamicc.Unit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.AbstractExpressionFormater;

public class JavaFormater extends AbstractExpressionFormater {
	public JavaFormater() {
		initParams();
	}

	protected void initParams() {
		operatorsMap.put(0, " == ");
		operatorsMap.put(1, " != ");
		operatorsMap.put(2, " > ");
		operatorsMap.put(3, " < ");
		operatorsMap.put(4, " >= ");
		operatorsMap.put(5, " <= ");

		linkMap.put(0, "");
		linkMap.put(1, Constants.LINK_AND_JAVA);
		linkMap.put(2, Constants.LINK_OR_JAVA);
		linkMap.put(3, "+");
		linkMap.put(4, "-");
		linkMap.put(5, "*");
		linkMap.put(6, "/");
		linkSet = new HashSet<String>(linkMap.values());

	}

	@Override
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
					for(Expression expression : expressions){
						tempStrBuffer.append(format(expression));
						tempStrBuffer.append(",");
					}
					if(tempStrBuffer.length()>0){
						tempStrBuffer.deleteCharAt(tempStrBuffer.length()-1);
						strBuf.append(tempStrBuffer);
					}
				}
				strBuf.append(")");
			} else {
				strBuf.append(cUnit.getName());
			}
		}
		return strBuf.toString();
	}

}
