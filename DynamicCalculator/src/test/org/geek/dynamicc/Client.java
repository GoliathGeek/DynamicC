package test.org.geek.dynamicc;

import java.math.BigDecimal;
import java.util.Random;

import org.geek.dynamicc.BooleanUnit;
import org.geek.dynamicc.BooleanExpression;
import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.BooleanFormater;
import org.triple.common.extension.SPIExtension;

public class Client {
	
	private static Random random = new Random();
	
	public static void main(String[] args) {
		initCalculatorUnits();
		BooleanExpression startExpression = createExpression();
		BooleanFormater expressionFormater = SPIExtension.getExtensionLoader(BooleanFormater.class).getExtension(
				"java");
		Group group = new Group("1", "Test", expressionFormater);
		group.setStartExpression(startExpression);
		System.out.println(group.toString());
	}
	
	private static void initCalculatorUnits() {
		CalculatorUnit<Integer> unitInteger = new CalculatorUnit<Integer>("IntegerUnit");
		CalculatorUnit<Double> unitDouble = new CalculatorUnit<Double>("DoubleUnit");
		CalculatorUnit<BigDecimal> unitBigDecimal = new CalculatorUnit<BigDecimal>("BigDecimalUnit");
		Constants.CALCULATORUNIT_CONTAINER.put(0, unitInteger);
		Constants.CALCULATORUNIT_CONTAINER.put(1, unitDouble);
		Constants.CALCULATORUNIT_CONTAINER.put(2, unitBigDecimal);
	}

	private static BooleanExpression createExpression() {
		BooleanExpression mainExpression = new BooleanExpression();
		addChildExpression(mainExpression);
		return mainExpression;
	}

	private static void addChildExpression(BooleanExpression parentExpression) {
		BooleanExpression childExpression = new BooleanExpression();
		childExpression.setLink(2 - random.nextInt(2)); 
		for (int i = 0; i < random.nextInt(3); i++) {
			addChildExpression(childExpression);
		}
		for (int i = 0; i < random.nextInt(4); i++) {
			childExpression.addBooleanUnit(createBooleanUnit());
		}
		parentExpression.addChildExpression(childExpression);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static BooleanUnit createBooleanUnit() {
		BooleanUnit booleanUnit = new BooleanUnit();
		booleanUnit.setCalculatorUnit(Constants.CALCULATORUNIT_CONTAINER.get(random.nextInt(3)));
		booleanUnit.setLogicMark(random.nextInt(6));
		booleanUnit.setKeyValue(random.nextInt(10));
		booleanUnit.setLink(2 - random.nextInt(2));
		return booleanUnit;
	}
}
