package zad2;

public class ChoryNaNoge extends Pacjent {

	public ChoryNaNoge(String nazwisko) {
		super(nazwisko);
	}

	@Override
	public String choroba() {
		return "noga";
	}

	@Override
	public String leczenie() {
		return "gips";
	}
}