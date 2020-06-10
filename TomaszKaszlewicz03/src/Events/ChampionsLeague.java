package Events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampionsLeague extends Tournament {

	private String currentChampion;
	
	public ChampionsLeague(int seats, String champion) {
		super(seats);
		this.currentChampion = champion;
	}
	
	@Override
	public void getTournamentScale() {
		System.out.println("Team event");
	}
}
