package org.geek.dynamicc.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dynamicc.CalculatorUnit;
import org.geek.dynamicc.Function;

public class Constants {

	public static final int LINK_AND = 1;
	public static final int LINK_OR = 2;
	public static final String LINK_AND_SQL = " and ";
	public static final String LINK_OR_SQL = " or ";
	public static final String LINK_AND_JAVA = " && ";
	public static final String LINK_OR_JAVA = " || ";

	public static final Map<Integer, CalculatorUnit<? extends Number>> CALCULATORUNIT_CONTAINER = new ConcurrentHashMap<Integer, CalculatorUnit<? extends Number>>();

	public static final Map<String, Function> FUNCTION_CAONTAINER = new ConcurrentHashMap<String, Function>();
}
