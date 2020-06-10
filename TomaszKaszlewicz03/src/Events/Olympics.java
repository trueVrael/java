package Events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Olympics extends Tournament {

	private String country;
	
	public Olympics(int seats, String country) {
		super(seats);
		this.country = country;
	}
	
	@Override
	public void getTournamentScale() {
		System.out.println("International");
	}
}
