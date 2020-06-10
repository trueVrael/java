package classes;


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

    public Person(PersonBuilder build) {
        super();
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.pesel = build.pesel;
    }
    
    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String pesel;


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
    }
}
