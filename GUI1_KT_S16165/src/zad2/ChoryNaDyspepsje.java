package zad2;

public class ChoryNaDyspepsje extends Pacjent { 

	public ChoryNaDyspepsje(String nazwisko) {
		super(nazwisko);
	}

	@Override
	public String choroba() {
		return "dyspepsja";
	}

	@Override
	public String leczenie() {
		return "węgiel";
	}
}