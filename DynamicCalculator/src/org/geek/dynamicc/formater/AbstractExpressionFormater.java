package org.geek.dynamicc.formater;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;
import org.geek.dynamicc.Function;
import org.geek.dynamicc.Unit;

public abstract class AbstractExpressionFormater implements ExpressionFormater {

	private String bracketLeft = "(";
	private String bracketRight = ")";

	protected Map<Integer, String> linkMap = new HashMap<Integer, String>();
	protected Map<Integer, String> operatorsMap = new ConcurrentHashMap<Integer, String>();
	protected Set<String> linkSet;

	@Override
	public String format(Expression expression) {
		StringBuffer strBuffer = new StringBuffer();
		if (expression.getChildExpressions().size() > 0) {
			StringBuffer strBufferTemp = new StringBuffer();
			int i = 0;
			for (Expression childExpression : expression.getChildExpressions()) {
				String tempStr = format(childExpression);
				if (tempStr.length() > 0) {
					if (i >= 1) {
						String linkStr = linkMap.get(childExpression.getLink()) == null ? "" : linkMap
								.get(childExpression.getLink());
						strBufferTemp.append(linkStr);
					}
					strBufferTemp.append(tempStr);
					i++;
				}
			}
			if (strBufferTemp.length() > 0) {
				strBuffer.append(bracketLeft + strBufferTemp + bracketRight);
			}
		}
		if (expression.getUnits().size() > 0) {
			for (Unit unit : expression.getUnits()) {
				String linkStr = linkMap.get(unit.getLink()) == null ? "" : linkMap.get(unit.getLink());
				strBuffer.append(linkStr);
				strBuffer.append(doFormat(unit));
			}
		}
		wipeTop(strBuffer);
		return strBuffer.toString();
	}

	private void wipeTop(StringBuffer strBuffer) {
		if (strBuffer.length() > 0) {
			for (String str : linkSet) {
				if (strBuffer.length() >= str.length()) {
					String topStr = strBuffer.substring(0, str.length());
					if (str.equals(topStr)) {
						strBuffer.delete(0, str.length());
						return;
					}
				}
			}
		}
	}

	protected abstract void initParams();

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
				strBuf.append(operatorsMap.get(bUnit.getLogicMark()));
				strBuf.append(strRight);
			}
		}
		return strBuf.toString();
	}

}
