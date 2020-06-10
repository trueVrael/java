package ModelRelacyjny;

import javax.persistence.Entity;

//dziedziczenie
@Entity
public class Kierowca extends Osoba {

	private String kategoriaPrawaJazdy;
	private double pensja;

	public String getKategoriaPrawaJazdy() {
		return kategoriaPrawaJazdy;
	}

	public void setKategoriaPrawaJazdy(String kategoriaPrawaJazdy) {
		this.kategoriaPrawaJazdy = kategoriaPrawaJazdy;
	}

	public double getPensja() {
		return pensja;
	}

	public void setPensja(int pensja) {
		this.pensja = pensja;
	}

}
