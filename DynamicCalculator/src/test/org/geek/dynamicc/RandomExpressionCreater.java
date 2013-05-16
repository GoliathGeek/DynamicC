package test.org.geek.dynamicc;

import java.util.Random;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Expression;
import org.geek.dynamicc.Function;
import org.geek.dynamicc.Unit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.function.Floor;

public class RandomExpressionCreater {

	private CalculatorExpressionCreater cCreater = new CalculatorExpressionCreater();

	private static Random random = new Random();

	private int createType = Constants.TYPE_MIX;

	public RandomExpressionCreater() {
	}

	public RandomExpressionCreater(int createType) {
		this.createType = createType;
	}

	public Expression createExpression() {
		Expression startExpression = new Expression();
		;
		if (startExpression != null) {
			addChildExpression(startExpression);
		}
		return startExpression;
	}

	private void addChildExpression(Expression parentExpression) {
		Expression childExpression = new Expression();
		if (this.createType == Constants.TYPE_BOOLEAN) {
			childExpression.setLink(2 - random.nextInt(2));
			for (int i = 0; i < random.nextInt(3); i++) {
				Expression unitExpression = new Expression();
				unitExpression.setLink(2 - random.nextInt(2));
				unitExpression.setUnit(createBooleanUnit());
				childExpression.addChildExpression(unitExpression);
			}
		} else if (this.createType == Constants.TYPE_CALCULATOR) {
			childExpression.setLink(6 - random.nextInt(4));
			for (int i = 0; i < random.nextInt(3); i++) {
				Expression unitExpression = new Expression();
				unitExpression.setLink(6 - random.nextInt(4));
				unitExpression.setUnit(createCalculatorUnit());
				childExpression.addChildExpression(unitExpression);
			}
		} else if (this.createType == Constants.TYPE_MIX) {

		}

		for (int i = 0; i < random.nextInt(3); i++) {
			addChildExpression(childExpression);
		}

		if (childExpression != null) {
			parentExpression.addChildExpression(childExpression);
		}
	}

	private Function createFunc() {
		Expression paramExpression = cCreater.createExpression();
		return new Floor(paramExpression);
	}

	private Unit createCalculatorUnit() {
		CalculatorUnit calculatorUnit = new CalculatorUnit("CalculatorUnit");
		if (random.nextInt(2) > 0) {
			calculatorUnit.setFunction(createFunc());
		}
		return calculatorUnit;
	}

	private BooleanUnit createBooleanUnit() {
		BooleanUnit booleanUnit = new BooleanUnit("");
		if (this.createType == Constants.TYPE_MIX) {
			booleanUnit.setLeft(cCreater.createExpression());
			booleanUnit.setRight(cCreater.createExpression());
		} else {
			Expression leftExpression = new Expression();
			leftExpression.setLink(6 - random.nextInt(4));
			leftExpression.setUnit(createCalculatorUnit());
			booleanUnit.setLeft(leftExpression);

			Expression rightExpression = new Expression();
			rightExpression.setLink(6 - random.nextInt(4));
			rightExpression.setUnit(createCalculatorUnit());
			booleanUnit.setRight(rightExpression);
		}

		booleanUnit.setLogicMark(random.nextInt(6));
		return booleanUnit;
	}
}
