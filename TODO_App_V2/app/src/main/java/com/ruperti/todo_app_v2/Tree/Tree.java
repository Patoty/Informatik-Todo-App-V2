package Tree;

public class Tree{
	
	private Knoten root;
	
	public Tree () {
		setRoot(new Knoten());
	}
	
	public Tree (Task wert) {
		setRoot(new Knoten(new Abschluss(), new Abschluss(), wert));
	}
	
	public Knoten getRoot() {
		return root;
	}

	public void setRoot(Knoten root) {
		this.root = root;
	}
	
	public void inorderAusgabe() {
		root.inorderAusgabe();
	}
	
	private void preorderAusgabe() {
		
	}
	
	private void postorderAusgabe() {
		
	}
	
	public void add(Task d) {
		root.add(d);
	}
	
	private void delete(Task d) {
		root.delete(d);
	}

	
	
}
