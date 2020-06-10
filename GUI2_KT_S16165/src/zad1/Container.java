package zad1;

import java.util.LinkedList;
import java.util.List;

public class Container {
	
	public List<Flower> flowers;
	protected String owner;
	
	public Container(String name){
		this.flowers = new LinkedList<Flower>();
		this.owner = name;
	}
	
}
