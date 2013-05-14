/**
 * 
 */
package org.geek.dynamicc;

import java.io.Serializable;
import java.util.List;

/**
 * 计算单元，包含 数据来源定义 & 处理函数定义
 * 通过doCalculate方法 得出Number结果
 * @author Cxl
 * @createTime 2013-5-13 
 */
@SuppressWarnings("serial")
public class CalculatorUnit<T extends Number> implements Serializable {
	private String id;
	private String unitName;
	// 计算连接符
	private int sign;

	private List<CalculatorUnit> childUnits;

	public CalculatorUnit(String unitName) {
		this.unitName = unitName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}
