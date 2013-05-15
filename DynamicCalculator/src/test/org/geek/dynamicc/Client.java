package test.org.geek.dynamicc;

import org.geek.dynamicc.Expression;
import org.geek.dynamicc.common.Constants;
import org.geek.dynamicc.formater.ExpressionFormater;
import org.triple.common.extension.SPIExtension;

public class Client {

	private static void initCalculatorUnits() {

	}

	public static void main(String[] args) {
		initCalculatorUnits();
		Expression startExpression = new RandomExpressionCreater(Constants.TYPE_CALCULATOR).createExpression();
		ExpressionFormater expressionFormater = SPIExtension.getExtensionLoader(ExpressionFormater.class).getExtension(
				"java");
		Group group = new Group("1", "Test", expressionFormater);
		group.setStartExpression(startExpression);
		System.out.println(group.toString());
		System.exit(0);
	}

}
