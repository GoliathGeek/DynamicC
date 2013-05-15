package test.org.geek.dynamicc;

import java.io.Serializable;

import org.geek.dynamicc.Expression;
import org.geek.dynamicc.formater.ExpressionFormater;

@SuppressWarnings("serial")
public class Group implements Serializable {
	private String id;
	private String name;
	private Expression startExpression;
	private ExpressionFormater formater;

	public Group(String id, String name, ExpressionFormater formater) {
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

	public Expression getStartExpression() {
		return startExpression;
	}

	public void setStartExpression(Expression startExpression) {
		this.startExpression = startExpression;
	}
}
