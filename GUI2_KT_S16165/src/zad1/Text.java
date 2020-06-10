package zad1;

import java.util.List;

abstract public class Text {

	public static String read(List<Flower> flowers) {
		String res="";
		PriceList pl = PriceList.getInstance();
		double pr;
		
		if(!flowers.isEmpty()){
			for(Flower flower: flowers){
				pr = pl.prices.get(flower.name) != null ? pl.prices.get(flower.name) : -1;
				res += System.lineSeparator() + flower.name + ", kolor: " + flower.color + ", ilość " + flower.counter + ", cena " + pr;
			}
		}
		else
			res += " -- pusto";
		return res;
	}

	
}
