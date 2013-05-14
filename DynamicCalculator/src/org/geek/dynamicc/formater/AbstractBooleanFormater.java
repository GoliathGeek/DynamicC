package org.geek.dynamicc.formater;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.BooleanExpression;
import org.geek.dynamicc.common.Constants;

public abstract class AbstractBooleanFormater implements BooleanFormater {

	protected Map<Integer, String> linkMap = new HashMap<Integer, String>();
	protected Map<Integer, String> operatorsMap = new ConcurrentHashMap<Integer, String>();

	public String format(BooleanExpression booleanExpression) {
		StringBuffer strBuffer = new StringBuffer();
		if (booleanExpression.getChildExpressions().size() > 0) {
			StringBuffer strBufferTemp = new StringBuffer();
			for (BooleanExpression childExpression : booleanExpression.getChildExpressions()) {
				String tempStr = format(childExpression);
				if (tempStr.length() > 0) {
					strBufferTemp.append(tempStr);
					strBufferTemp.append(linkMap.get(childExpression.getLink()));
				}
			}
			wipeEnd(strBufferTemp);
			if (strBufferTemp.length() > 0) {
				strBuffer.append(" ( " + strBufferTemp + " ) ");
				strBuffer.append(linkMap.get(booleanExpression.getLink()));
			}
		}
		if (booleanExpression.getBooleanUnits().size() > 0) {
			for (BooleanUnit<?> booleanUnit : booleanExpression.getBooleanUnits()) {
				strBuffer.append(doFormat(booleanUnit));
			}
		}
		wipeEnd(strBuffer);
		return strBuffer.toString();
	}

	protected void wipeEnd(StringBuffer strBuffer) {
		String endStr;
		String linkAnd = linkMap.get(Constants.LINK_AND);
		String linkOr = linkMap.get(Constants.LINK_OR);
		if (strBuffer.length() >= linkAnd.length()) {
			endStr = strBuffer.substring(strBuffer.length() - linkAnd.length(), strBuffer.length());
			if (endStr.endsWith(linkAnd)) {
				strBuffer.delete(strBuffer.length() - linkAnd.length(), strBuffer.length());
			}
		}
		if (strBuffer.length() >= linkOr.length()) {
			endStr = strBuffer.substring(strBuffer.length() - linkOr.length(), strBuffer.length());
			if (endStr.endsWith(linkOr)) {
				strBuffer.delete(strBuffer.length() - linkOr.length(), strBuffer.length());
			}
		}
	}

	protected abstract void initMap();
	protected abstract Object doFormat(BooleanUnit<?> booleanUnit);

}
