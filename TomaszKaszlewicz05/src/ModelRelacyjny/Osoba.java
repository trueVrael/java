package ModelRelacyjny;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Osoba {

	@Id
	@GeneratedValue
	private int id;
	private String imie;
	private String nazwisko;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

}
