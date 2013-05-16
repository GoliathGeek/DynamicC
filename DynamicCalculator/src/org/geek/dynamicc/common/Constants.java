package org.geek.dynamicc.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.geek.dynamicc.CalculatorUnit;

public class Constants {

	public static final int LINK_AND = 1;
	public static final int LINK_OR = 2;
	public static final String LINK_AND_SQL = " and ";
	public static final String LINK_OR_SQL = " or ";
	public static final String LINK_AND_JAVA = " && ";
	public static final String LINK_OR_JAVA = " || ";

	public static final Map<Integer, CalculatorUnit> CALCULATORUNIT_CONTAINER = new ConcurrentHashMap<Integer, CalculatorUnit>();

	public static final int TYPE_BOOLEAN = 0;
	public static final int TYPE_CALCULATOR = 1;
	public static final int TYPE_MIX = 2;
}
