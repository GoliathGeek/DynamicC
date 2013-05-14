package test.org.geek.dynamicc;

import java.io.Serializable;

import org.geek.dynamicc.BooleanExpression;
import org.geek.dynamicc.formater.BooleanFormater;

@SuppressWarnings("serial")
public class Group implements Serializable {
	private String id;
	private String name;
	private BooleanExpression startExpression;
	private BooleanFormater formater;

	public Group(String id, String name, BooleanFormater formater) {
		this.id = id;
		this.name = name;
		this.formater = formater;
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

	public String toString() {
		return "Group id:" + this.id + " name:" + name + "={" + this.formater.format(getStartExpression()) + "}";
	}

	public BooleanExpression getStartExpression() {
		return startExpression;
	}

	public void setStartExpression(BooleanExpression startExpression) {
		this.startExpression = startExpression;
	}
}
