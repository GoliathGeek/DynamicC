package org.geek.dynamicc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Expression implements Serializable {
	private String id;
	private String name;
	// 连接符
	private int link;

	protected List<Expression> childExpressions = new ArrayList<Expression>();
	protected List<Unit> units = new ArrayList<Unit>();

	public void addUnit(Unit unit) {
		this.units.add(unit);
	}

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

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}
}
