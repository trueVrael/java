package People;

import Health.Healthy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class Coach extends Person {

	private  String rank;
	private int salary;
	
	public Coach(PersonBuilder build, String rank, int salary) {
		super(build);
		this.rank = rank;
		this.salary = salary;
	}
	
	public Coach(Person prevPerson, String rank, int salary) {
		super(new Person.PersonBuilder()
				.firstName(prevPerson.firstName)
				.lastName(prevPerson.lastName)
				.pesel(prevPerson.pesel)
				.health(prevPerson.getHealth()));
		
		this.rank = rank;
		this.salary = salary;
	}
	public int getIncome() {
		return getSalary();
	}
	
	public void appointment() {
		System.out.println("Making an appointment for a lesson");
	}
}
