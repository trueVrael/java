package People;

import Health.Healthy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import Exceptions.DynamicException;
import Exceptions.*;

@Getter
@Setter
@ToString(callSuper = true)

public class Coach extends Person {

	private  String rank;
	private int salary;
	
	public Coach(PersonBuilder build, String rank, int salary) throws UniqueException {
		super(build);
		this.rank = rank;
		this.salary = salary;
	}
	
	public Coach(Person prevPerson, String rank, int salary) throws UniqueException {
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
	
	public void changeSalary(int newSalary) throws DynamicException {
		
		if(newSalary < this.salary)
			throw new DynamicException("New salary can't be lower than previous salary");
	}
	
	public void appointment() {
		System.out.println("Making an appointment for a lesson");
	}
}
