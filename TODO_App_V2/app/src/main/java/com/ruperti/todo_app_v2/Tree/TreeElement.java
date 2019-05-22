package Tree;

public abstract class TreeElement {
	
	public abstract void inorderAusgabe();
	public abstract void preorderAusgabe();
	public abstract void postorderAusgabe();
	public abstract TreeElement add(Task d);
	protected abstract TreeElement addRight(TreeElement t);
	protected abstract TreeElement delete(Task value);
}
