package test.org.geek.dynamicc;

import java.util.Random;

import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;

public class CalculatorExpressionCreater {
	private static Random random = new Random();

	public Expression createExpression() {
		Expression expression = new Expression();
		CalculatorUnit unit = new CalculatorUnit("param");
		if (random.nextInt(2) > 0) {
			unit.setConstant(random.nextInt(100));
		}
		expression.addUnit(unit);
		return expression;
	}

}
