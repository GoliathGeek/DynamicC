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
	protected Map<Integer, String> logicMarkMap = new ConcurrentHashMap<Integer, String>();
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
				if (expression.getChildExpressions().size() > 1) {
					strBuffer.append(bracketLeft + strBufferTemp + bracketRight);
				} else {
					strBuffer.append(strBufferTemp);
				}
			}
		}
		if (expression.getUnit() != null) {
			strBuffer.append(doFormat(expression.getUnit()));
		}
		return strBuffer.toString();
	}

	protected abstract Object doFormat(Unit unit);

	protected abstract void initParams();

}
