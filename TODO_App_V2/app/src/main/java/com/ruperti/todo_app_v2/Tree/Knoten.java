package Tree;

public class Knoten extends TreeElement{
	
	private TreeElement linkerNachfolger;
	private TreeElement rechterNachfolger;
	private Task data;
	
	public Knoten() {
		
	}
	
	public Knoten(TreeElement linkerNachfolger, TreeElement rechterNachfolger, Task data) {
		this.linkerNachfolger = linkerNachfolger;
		this.rechterNachfolger = rechterNachfolger;
		this.data = data;
	}

	public TreeElement getLinkerNachfolger() {
		return linkerNachfolger;
	}

	public void setLinkerNachfolger(TreeElement linkerNachfolger) {
		this.linkerNachfolger = linkerNachfolger;
	}

	public TreeElement getRechterNachfolger() {
		return rechterNachfolger;
	}

	public void setRechterNachfolger(TreeElement rechterNachfolger) {
		this.rechterNachfolger = rechterNachfolger;
	}

	public Task getData() {
		return data;
	}

	public void setData(Task data) {
		this.data = data;
	}

	@Override
	public void inorderAusgabe() {
		linkerNachfolger.inorderAusgabe();
		System.out.println(this.data.getValue());
		rechterNachfolger.inorderAusgabe();
	}

	@Override
	public void preorderAusgabe() {
		System.out.println(this.data.getValue());
		linkerNachfolger.preorderAusgabe();
		rechterNachfolger.preorderAusgabe();
	}

	@Override
	public void postorderAusgabe() {
		linkerNachfolger.postorderAusgabe();
		rechterNachfolger.postorderAusgabe();
		System.out.println(this.data.getValue());
	}

	@Override
	public TreeElement add(Task d) {
		if (this.data.compareTo(d) == 1) {
			linkerNachfolger.add(d);
			return this;
		}else if (this.data.compareTo(d) == -1) {
			rechterNachfolger.add(d);
			return this;
		}else {
			System.out.println("Error: Das Element ist schon vorhanden");
			return this;
		}
	}

	@Override
	protected TreeElement delete(Task value) {
		
		if (this.data.compareTo(value) == 0) {
			this.linkerNachfolger.addRight(rechterNachfolger);
			return linkerNachfolger;
		}else if(this.data.compareTo(value) == 1) {
			this.linkerNachfolger.delete(value);
			return this;
		}else {
			this.rechterNachfolger.delete(value);
			return this; 
		}
	}

	@Override
	protected TreeElement addRight(TreeElement t) {
		rechterNachfolger =  rechterNachfolger.addRight(t);
		return this;
	}
	
}
