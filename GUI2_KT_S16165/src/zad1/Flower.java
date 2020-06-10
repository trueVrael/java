package zad1;

abstract public class Flower {
	
	public int counter = 0;
	public String color = "brak";
	public String name = "brak";
	
	public Flower(int counter, String color, String name){
		this.counter = counter;
		this.color = color;
		this.name = name;
	}
}