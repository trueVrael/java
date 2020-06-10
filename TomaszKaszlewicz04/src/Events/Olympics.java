package Events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import Exceptions.StaticException;

@Getter
@Setter
@ToString
public class Olympics extends Tournament {

	private String country;
	
	public Olympics(int seats, String country) throws StaticException {
		super(seats);
		this.country = country;
	}
    
	@Override
	public void getTournamentScale() {
		System.out.println("International");
	}
}
