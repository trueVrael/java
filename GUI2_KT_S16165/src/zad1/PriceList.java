package zad1;

import java.util.HashMap;

public class PriceList {
	
	private static PriceList singleton = new PriceList();
	
	public HashMap<String, Double> prices;
	
	private PriceList(){
		prices = new HashMap<String, Double>();
	}
	
	public static PriceList getInstance(){
		return singleton;
	}

	public void put(String string, double d) {
		prices.put(string, d);	
	}

}
