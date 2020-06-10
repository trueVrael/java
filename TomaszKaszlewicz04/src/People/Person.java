package People;


import classes.ObjectPlus4;
import Health.*;
import Exceptions.DynamicException;
import Exceptions.StaticException;
import Exceptions.UniqueException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.*;

import Events.Tournament;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Person extends ObjectPlus4 {

    protected String firstName;
    protected String lastName;
    protected String pesel;
    protected PersonStatus health;
    
    private static final Set<String> pesels = new HashSet<>();
    
    public Person(PersonBuilder build) throws UniqueException {
        super();
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.health = build.health;
        
        if(pesels.contains(build.pesel))
        	throw new UniqueException("Pesel", Person.class);
        else {
        	this.pesel = build.pesel;
        	Person.pesels.add(build.pesel);
        }
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
