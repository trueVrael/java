package classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Team extends ObjectPlusPlus{

    protected String name;
    protected String country;
    protected int division;

    public Team(TeamBuilder build) {
        super();
        this.name = build.name;
        this.country = build.country;
        this.division = build.division;
    }
    
    public static class TeamBuilder {

        private String name;
        private String country;
        private int division;


        public Team.TeamBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Team.TeamBuilder country(String country) {
            this.country = country;
            return this;
        }

        public Team.TeamBuilder division(int division) {
            this.division = division;
            return this;
        }
    }	
}
