package Events;

import lombok.Getter;
import lombok.ToString;
import classes.ObjectPlus4;
import Exceptions.CustomException;

@Getter
@ToString
public class Attendant extends ObjectPlus4 {

    private String name;
    private String school;
    
    public Attendant(String name) {
        this.name = name;

        this.addXORRole("Organizer");
        this.addXORRole("Participant");
    }

    public void setSchool(String schoolName) throws CustomException {

        if(schoolName.contains("UK")) {
            this.school = schoolName;
        } else {
            throw new CustomException("Attendant has to be a graduate from UK university");
        }

    }
}
