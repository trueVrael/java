package zad2;

public class ChoryNaGlowe extends Pacjent {

	public ChoryNaGlowe(String nazwisko) {
		super(nazwisko);
	}

	@Override
	public String choroba() {
		return "głowa";
	}

	@Override
	public String leczenie() {
		return "aspiryna";
	}
}