/**
 * 
 */
package org.geek.dynamicc;

/**
 * 计算单元，包含 数据来源定义 & 处理函数定义
 * 通过doCalculate方法 得出Number结果
 * @author Cxl
 * @createTime 2013-5-13 
 */
@SuppressWarnings("serial")
public class CalculatorUnit extends Unit {
	public CalculatorUnit(String name) {
		super(name);
	}

	private Function function;

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
