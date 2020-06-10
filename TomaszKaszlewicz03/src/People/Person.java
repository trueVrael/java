package People;


import classes.ObjectPlusPlus;
import Health.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Person extends ObjectPlusPlus {

    protected String firstName;
    protected String lastName;
    protected String pesel;
    protected PersonStatus health;
    
    public Person(PersonBuilder build) {
        super();
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.pesel = build.pesel;
        this.health = build.health;
    }
    
    public String showClass() {
    	return this.getClass().getSimpleName() + ":" + firstName + " " + lastName;
    }
    
    public abstract int getIncome();
    
    public Status getPersonStatus() {
    	return this.health.getPersonStatus();
    }
    
    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String pesel;
        private PersonStatus health;

        public Person.PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Person.PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Person.PersonBuilder pesel(String pesel) {
            this.pesel = pesel;
            return this;
        }
        
        public Person.PersonBuilder health(PersonStatus health) {
            this.health = health;
            return this;
        }
    }
}
