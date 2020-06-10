package app;

import classes.Coach;
import classes.ObjectPlus;
import classes.ObjectPlusPlus;
import classes.Person;
import classes.Player;
import classes.Team;
import classes.Period;

import java.time.LocalDate;

/*
 klasy:
 Player
 Team
 Coach
 Racket
 
 atrybut (klasa):
 Period
 
 Asocjacje:
 binarna: Player - Coach
 z atrybutem: Player - Team
 kwalifikowana: Coach - Team
 kompozycja: Player - Racket
 */

public class Main {
	
	private static final String ASSOCIATIONS_SEPARATOR = "---------------------------------------------------------------------------------------";
	 
	private static Player p1;
	private static Player p2;
	private static Player p3;
	private static Coach c1;
	private static Coach c2;
	private static Coach c3;
	private static Team t1;
	private static Team t2;
	private static Period period1;
	private static Period period2;
	private static Period period3;
	private static Period period4;
	private static Player.Racket r1;
	private static Player.Racket r2;
	private static Player.Racket r3;
	
	public static void main(String[] args) {
		
		//inicjalizacja danych
	    p1 = new Player(
	    		new Person.PersonBuilder()
	    				.firstName("Timo")
	    				.lastName("Boll")
	    				.pesel("81030825481"),
	    		"left");  
	    p2 = new Player(
	    		new Person.PersonBuilder()
	    				.firstName("Andrzej")
	    				.lastName("Grubba")
	    				.pesel("58051472109"),
	    		"right");
	    p3 = new Player(
	    		new Person.PersonBuilder()
	    				.firstName("Jan")
	    				.lastName("Nowak")
	    				.pesel("99120123693"),
	    		"right"); 
	    c1 = new Coach(
	    		new Person.PersonBuilder()
	    				.firstName("Ryusuke")
	    				.lastName("Sakamoto")
	    				.pesel("84112586007"),
	    		"regional");   
	    c2 = new Coach(
	    		new Person.PersonBuilder()
	    				.firstName("Jorg")
	    				.lastName("Roskopff")
	    				.pesel("69052254213"),
	    		"national");
	    c3 = new Coach(
	    		new Person.PersonBuilder()
	    				.firstName("Damian")
	    				.lastName("Kowalski")
	    				.pesel("90021733079"),
	    		"local");
	    t1 = new Team(
	    		 new Team.TeamBuilder()
	    				.name("Bogoria Grodzisk Mazowiecki")
	    				.country("Poland")
	    				.division(1)
	    			);    
	    t2 = new Team(
	    		 new Team.TeamBuilder()
	    				.name("Borusia Dusseldorf")
	    				.country("Germany")
	    				.division(1)
	    			);
	    
        period1 = new Period(LocalDate.of(2018, 9, 1), LocalDate.of(2019, 12, 31), p1, t1);     
        period2 = new Period(LocalDate.of(2020, 1, 1), null, p1, t2);    
        period3 = new Period(LocalDate.of(2018, 9, 1), null, p2, t1);       
        period4 = new Period(LocalDate.of(2020, 1, 1), null, p3, t2);
        
		/*
		 * asocjacja binarna wiele do wielu.
	     * Kazdy zawodnik moze miec kilku trenerow personalnych niezale¿nie od przynale¿noœci klubowej.
	     * Kazdy trener moze miec grupe zawodnikow
	    */
	    
	    p1.addBinaryAssociation("Coaches", "Players", c1);
	    p1.addBinaryAssociation("Coaches", "Players", c2);
	    p1.addBinaryAssociation("Coaches", "Players", c3);
	    p2.addBinaryAssociation("Coaches", "Players", c2);
	    p2.addBinaryAssociation("Coaches", "Players", c3);
	    p3.addBinaryAssociation("Coaches", "Players", c1);
	    p3.addBinaryAssociation("Coaches", "Players", c3);
	    
	    System.out.println("Asocjacje binarne:");
	    
	    printAssociation(p1, p1.getLastName(), "Coaches");
	    printAssociation(p2, p2.getLastName(), "Coaches");
	    printAssociation(p3, p3.getLastName(), "Coaches");
	    printAssociation(c1, c1.getLastName(), "Players");
	    printAssociation(c2, c2.getLastName(), "Players");
	    printAssociation(c3, c3.getLastName(), "Players");
	    
	    System.out.println(ASSOCIATIONS_SEPARATOR);
	    
	    /*
	     * asocjacja z atrybutem wiele do wielu.
	     * Ka¿dy zawodnik móg³ wystepowac w wielu klubach i w kazdym klubie mzoe grac wielu zawodnikow.
	     * Klasa asocjacji jest okres gry dla danego klubu        
	    */
	   
        p1.addAssociationWithAttributeCls("Players", "Teams", t1, period1);
        p1.addAssociationWithAttributeCls("Players", "Teams", t2, period2);
        p2.addAssociationWithAttributeCls("Players", "Team", t1, period3);
        p3.addAssociationWithAttributeCls("Players", "Team", t2, period4);
        
        System.out.println("Asocjacje z atrybutem:");
        printAssociation(p1, p1.getLastName(), "Teams");
        printAssociation(p2, p1.getLastName(), "Teams");
        printAssociation(p3, p1.getLastName(), "Teams");
        printAssociation(t1, t1.getName(), "Players");
        printAssociation(t2, t2.getName(), "Players");
        
	    System.out.println(ASSOCIATIONS_SEPARATOR);
	    
	    /*
	     * asocjacja  kwalifikowana jeden do wielu.
	     * Ka¿dy trener mo¿e pracowac dla jednego klubu, ale w jednym klubie mo¿e by wielu trenerów.
	     * Kwalifikatorem jest PESEL trenera
	     */
	    
	    t1.addQualifiedAssociation("Hires", "Coaches", c1, c1.getPesel());
	    t1.addQualifiedAssociation("Hires", "Coaches", c2, c2.getPesel());
	    t2.addQualifiedAssociation("Hires", "Coaches", c3, c3.getPesel());
	    
	    System.out.println("Asocjacje kwalifikowane:");
        printAssociation(t1, t1.getName(), "Hires");
        printAssociation(t2, t2.getName(), "Hires");
        printAssociation(c1, c1.getPesel(), "Coaches");
        printAssociation(c2, c2.getPesel(), "Coaches");
        printAssociation(c3, c3.getPesel(), "Coaches");
        
        System.out.println(ASSOCIATIONS_SEPARATOR);
        
	    /*
	     * Kompozycja
	     * Zawodnik mo¿e miec wiele rakietek lub chwilowo zadnej.
	     * Rakietka nie ma sensu istnienia bez gracza, ktory by nia gral.
	     */
        
        try {
            r1 = p1.addRacket("Butterfly", 2);
            r2 = p1.addRacket("Stiga", 10);
            r3 = p2.addRacket("Donic", 1);
        } catch (Exception e) {
        	 System.out.println("Part already has a parent");
        }

        try {
            r1 = p1.addRacket("Butterfly", 2);
        } catch (Exception e) {
            System.out.println("Part already has a parent");
        }
        
	    System.out.println("Kompozycja:");
	    
        printAssociation(p1, p1.getFirstName(),"Player");
        printAssociation(p2, p2.getFirstName(),"Player");
        printAssociation(r1, r1.getName(),"Racket");
        printAssociation(r2, r2.getName(),"Racket");
        printAssociation(r3, r3.getName(),"Racket");
        
        System.out.println(ASSOCIATIONS_SEPARATOR);    
	}
	
	private static void printAssociation(ObjectPlusPlus obj, String name, String roleName) {
        System.out.println(obj.getClass().getSimpleName() + " " + name + " , role: " + roleName);
        try {
            obj.showAssociationsForRole(roleName, System.out);
        } catch (Exception e) {
            System.out.println("Role not found");
        }
    }
}
