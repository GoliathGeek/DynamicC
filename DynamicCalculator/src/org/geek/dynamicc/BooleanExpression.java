package org.geek.dynamicc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class BooleanExpression implements Serializable {
	private String id;
	private String name;
	// 连接符
	private int link;
	private List<BooleanUnit<?>> booleanUnits = new ArrayList<BooleanUnit<?>>();
	private List<BooleanExpression> childExpressions = new ArrayList<BooleanExpression>();

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

	public List<BooleanUnit<?>> getBooleanUnits() {
		return booleanUnits;
	}

	public void setBooleanUnits(List<BooleanUnit<?>> booleanUnits) {
		this.booleanUnits = booleanUnits;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public void addChildExpression(BooleanExpression childExpression) {
		getChildExpressions().add(childExpression);
	}
	
	public void addBooleanUnit(BooleanUnit<?> booleanUnit) {
		booleanUnits.add(booleanUnit);
	}

	public List<BooleanExpression> getChildExpressions() {
		return childExpressions;
	}

	public void setChildExpressions(List<BooleanExpression> childExpressions) {
		this.childExpressions = childExpressions;
	}
}
