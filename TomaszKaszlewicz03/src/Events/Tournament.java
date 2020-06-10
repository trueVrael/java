package Events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tournament {

	protected int seats;
	public String scale;
	
	public Tournament(int seats, String scale) {
		this.seats = seats;
		this.scale = scale;
	}
	
	public Tournament(int seats) {
		this.seats = seats;
	}
	
	public void getTournamentScale() {
		System.out.println(this.scale);
	}
	
}
