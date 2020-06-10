package ModelRelacyjny;

import javax.persistence.ManyToOne;

public class Manager extends Osoba {

	private String stanowisko;

	// asocjacja
	@ManyToOne
	private Firma firma;

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

}
