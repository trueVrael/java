package zad3;

public class ReversibleDouble implements Reversible {

	double number;
	
	public ReversibleDouble(double nr) {
		this.number = nr;
	}

	@Override
	public String toString() {
		return Double.toString(this.number);
	}

	@Override
	public void reverse() {
		this.number = number * (1/(number*number));
	}

}
