package zad1;


public class ShoppingCart extends Container {
	
	public ShoppingCart(String name){
		super(name);
	}
	
	public String toString(){
		
		String res = "Wózek właściciel " + this.owner;
		res += Text.read(this.flowers);
		
		return res;
	}
}
