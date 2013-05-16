package org.geek.dynamicc;

@SuppressWarnings("serial")
public class BooleanUnit extends Unit implements Calculable {

	public BooleanUnit(String name) {
		super(name);
	}

	private boolean negation = false;

	private Expression left;
	// 逻辑计算符
	private int logicMark;
	private Expression right;

	public int getLogicMark() {
		return logicMark;
	}

	public void setLogicMark(int logicMark) {
		this.logicMark = logicMark;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	@Override
	public Number doCalculate() {
		// TODO Auto-generated method stub
		return null;
	}

}
