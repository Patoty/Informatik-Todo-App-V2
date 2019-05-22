package Tree;

public class Abschluss extends TreeElement {

	@Override
	public void inorderAusgabe() {
		
	}

	@Override
	public void preorderAusgabe() {
		
	}

	@Override
	public void postorderAusgabe() {
		
	}

	@Override
	public TreeElement add(Task d) {
		return new Knoten(new Abschluss(), this, d);
	}

	@Override
	public TreeElement delete(Task value) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public TreeElement addRight(TreeElement t) {
		// TODO Auto-generated method stub
		return t;
	}
	
}
