package zad2;

public abstract class Pacjent {
	
	private String nazwisko;
	
	public Pacjent(String nazwisko){
		this.nazwisko = nazwisko;
	}
	
	public String nazwisko(){
		return nazwisko;
	}
	
	public abstract String choroba();	
	public abstract String leczenie();

}
