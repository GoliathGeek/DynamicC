package org.geek.dynamicc.formater;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dynamicc.Expression;
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
						strBufferTemp.append(linkMap.get(childExpression.getLink()));
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
				strBuffer.append(linkMap.get(unit.getLink()));
				strBuffer.append(doFormat(unit));
			}
		}
		wipeTop(strBuffer);
		return strBuffer.toString();
	}

	private void wipeTop(StringBuffer strBuffer) {
		if(strBuffer.length()>0){
			String topChar = String.valueOf(strBuffer.charAt(0));
			if (linkSet.contains(topChar)) {
				strBuffer.delete(0, 1);
			}
		}
	}

	protected abstract void initParams();

	protected abstract String doFormat(Unit unit);

}
