package zad1;

import java.util.Iterator;

public class Customer {

	private double cash;
	private String name;
	private ShoppingCart cart;
	
	public String getName(Customer cust){
		return this.name;
	}
	
	public Customer(String string, double i) {
		this.cash = i;
		this.name = string;
		this.cart = new ShoppingCart(this.name);
	}

	public void pay() {
		// TODO Auto-generated method stub
		double price, cnt;
		PriceList pl = PriceList.getInstance();
		Iterator<Flower> flower = this.cart.flowers.iterator();
		
		while(flower.hasNext()){
			Flower tmp = flower.next();
			cnt = pl.prices.get(tmp.name) != null ? pl.prices.get(tmp.name) : -1;
			price = tmp.counter*cnt;
			if((price < this.cash) && (cnt != -1)){
				this.cash -= price;
			}
			else flower.remove();
		}
		
	}

	public ShoppingCart getShoppingCart() {
		// TODO Auto-generated method stub
		return this.cart;
	}

	public String getCash() {
		// TODO Auto-generated method stub
		return String.valueOf(this.cash);
	}

	public void pack(Box box) {
		for(Flower flower : this.cart.flowers){
			box.flowers.add(flower);
		}
		this.cart.flowers.clear();
	}

	public void get(Flower flower) {
		this.cart.flowers.add(flower);		
	}
	
}
