package org.geek.dynamicc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Expression implements Serializable, Calculable {
	private String id;
	private String name;
	// 连接符
	private int link;

	protected List<Expression> childExpressions = new ArrayList<Expression>();
	private Unit unit;

	public void addChildExpression(Expression childExpression) {
		this.childExpressions.add(childExpression);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getChildExpressions() {
		return childExpressions;
	}

	public void setChildExpressions(List<Expression> childExpressions) {
		this.childExpressions = childExpressions;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public Number doCalculate() {
		// TODO Auto-generated method stub
		return null;
	}
}
