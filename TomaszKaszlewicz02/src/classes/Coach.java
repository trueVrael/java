package classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class Coach extends Person {

	private  String rank;
	
	public Coach(PersonBuilder build, String rank) {
		super(build);
		this.rank = rank;
	}
}
