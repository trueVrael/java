package People;

import classes.ObjectPlusPlus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import Exceptions.*;

@Getter
@Setter
@ToString(callSuper = true)

public class Player extends Person {

	private int prizes;
	private String hand;
	
	public Player(PersonBuilder build, String hand, int prizes) throws UniqueException {
		super(build);
		this.hand = hand;
		this.prizes = prizes;
	}
	
	public int getIncome() {
		return getPrizes();
	}
    
	public void prepare() {
		System.out.println("Preparing for the match");
	}
}
