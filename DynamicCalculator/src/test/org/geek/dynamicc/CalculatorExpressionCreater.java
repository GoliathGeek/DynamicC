package test.org.geek.dynamicc;

import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;

public class CalculatorExpressionCreater {

	public Expression createExpression() {
		Expression expression = new Expression();
		CalculatorUnit unit = new CalculatorUnit("param");
		expression.addUnit(unit);
		return expression;
	}

}
