package zad1;

public class Box extends Container {
		
	public Box(Customer customer) {
		super(customer.getName(customer));
	}
	
	public String toString(){
		
		String res = "Pudełko właściciel " + this.owner;
		res += Text.read(this.flowers);

		return res;
	}

}
