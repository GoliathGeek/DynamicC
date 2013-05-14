package test.org.geek.dynamicc;

import java.math.BigDecimal;
import java.util.Random;

import org.geek.dynamicc.Calculator;
import org.geek.dynamicc.CalculatorRule;
import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.CalculatorFormater;
import org.triple.common.extension.SPIExtension;

public class Client {
	
	private static Random random = new Random();
	
	public static void main(String[] args) {
		initCalculatorUnits();
		CalculatorRule startRule = createRule();
		CalculatorFormater formulaFormater = SPIExtension.getExtensionLoader(CalculatorFormater.class).getExtension(
				"java");
		Group group = new Group("1", "TestJava", formulaFormater);
		group.setStartCalculatorRule(startRule);
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

	private static CalculatorRule createRule() {
		CalculatorRule mainRule = new CalculatorRule();
		addChildRule(mainRule);
		return mainRule;
	}

	private static void addChildRule(CalculatorRule parentRule) {
		CalculatorRule childRule = new CalculatorRule();
		childRule.setLink(2 - random.nextInt(2)); 
		for (int i = 0; i < random.nextInt(3); i++) {
			addChildRule(childRule);
		}
		for (int i = 0; i < random.nextInt(4); i++) {
			childRule.addCalculator(createCalculator());
		}
		parentRule.addChildRule(childRule);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Calculator createCalculator() {
		Calculator calculator = new Calculator();
		calculator.setCalculatorUnit(Constants.CALCULATORUNIT_CONTAINER.get(random.nextInt(3)));
		calculator.setLogicMark(random.nextInt(6));
		calculator.setKeyValue(random.nextInt(10));
		calculator.setLink(2 - random.nextInt(2));
		return calculator;
	}
}
