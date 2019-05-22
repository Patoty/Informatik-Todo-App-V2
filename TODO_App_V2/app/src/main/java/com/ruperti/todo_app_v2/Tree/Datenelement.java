package Tree;

public class Datenelement {
	private int value;
	
	public Datenelement() {
		
	}
	
	public Datenelement(int value) {
		this.setValue(value);
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int compareTo (Task d) {
		if (this.value > d.getValue()) {
			return 1;
		}else if (this.value < d.getValue()) {
			return -1;
		}else {
			return 0;
		}
	}
}
