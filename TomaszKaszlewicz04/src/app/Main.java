package app;

import classes.ObjectPlus;
import classes.ObjectPlusPlus;

import java.time.LocalDate;

import People.Coach;
import People.Person;
import People.Player;
import People.PlayingCoach;
import GameObject.Racket;
import Health.*;
import Events.*;
import Exceptions.*;

/*
ograniczenia

Atrybutów
Unique
Subset
Ordered
Xor
Ograniczenie wlasne

*/

public class Main {

private static final String SEPARATOR = "---------------------------------------------------------------------------------------";
	
	public static void main(String[] args) throws Exception {
		
		Player p1 = null;
		Player p2 = null;
		Player p3 = null;
		Coach c1 = null;
		Tournament e2 = null;
		
		//inicjalizacja danych
		try {
            e2 = new Tournament(100000, "local");
            System.out.println("Created new tournament: " + e2);
        } catch (StaticException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
		
		try {
		    p1 = new Player(
		    		new Person.PersonBuilder()
		    				.firstName("Timo")
		    				.lastName("Boll")
		    				.pesel("81030825481")
		    				.health(new Healthy()),
		    		"left", 20000); 
		} catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

		try {
		    p2 = new Player(
		    		new Person.PersonBuilder()
    					.firstName("Andrzej")
    					.lastName("Grubba")
    					.pesel("58051472109")
		    				.health(new Healthy()),
		    		"right", 15000); 
		} catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

		try {
		    p3 = new Player(
		    		new Person.PersonBuilder()
    					.firstName("Jan")
    					.lastName("Nowak")
    					.pesel("99120123693"),
		    		"right", 3000); 
		} catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
		//c1 i pc te same pesele
        try {
    	    c1 = new Coach(
    	    		new Person.PersonBuilder()
    	    			.firstName("Ryusuke")
    	    			.lastName("Sakamoto")
    	    			.pesel("84112586007")
    	    				.health(new Healthy()),
    	    		"regional", 5000);
    	    
        } catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

	    try {
		    PlayingCoach pc = new PlayingCoach(
					new Person.PersonBuilder()
					.firstName("Zbigniew")
					.lastName("Grzalka")
					.pesel("84112586007"),
					"regional", 5000, "Right", 50000);
	    } catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
	    /*
	     *  Atrybutow
	     *  W tym podpunkt drugi ograniczenie Unique
	     */
		
		System.out.println("Ograniczenie Atrybutow");
		
		//ograniczenie statyczne
		try {
            Tournament e1 = new Tournament(10, "local");
            System.out.println("Created new tournament: " + e1);
        } catch (StaticException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

		//ograniczenie dynamiczne
        try {
    	    Coach c2 = new Coach(
    	    		new Person.PersonBuilder()
    	    				.firstName("Jorg")
    	    				.lastName("Roskopff")
    	    				.pesel("69052254213")
    	    				.health(new Healthy()),
    	    		"national", 6000);
    	    
    	    c2.changeSalary(5000);
    	    
        } catch (UniqueException | DynamicException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        //ograniczenie Unique
        try {
    	    Player p4 = new Player(
    	    		new Person.PersonBuilder()
    	    				.firstName("Andrzej")
    	    				.lastName("Grubba")
    	    				.pesel("69052254213")
    	    				.health(new Healthy()),
    	    		"right", 500000);
            System.out.println(p4);
        } catch (UniqueException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
		
		System.out.println(SEPARATOR);
		
		//ograniczenie Ordered. Porownuje termin odbycia sie zawodow
		System.out.println("Ograniczenie Ordered:");
		
		e2.addEvent(10000,LocalDate.of(2020, 1, 1));
		System.out.println(e2.getAttendanceHistory());
	    
		e2.addEvent(20000,LocalDate.of(2018, 2, 2));
		System.out.println(e2.getAttendanceHistory());
		
		e2.addEvent(18000,LocalDate.of(2019, 3, 3));
		System.out.println(e2.getAttendanceHistory());
		
		System.out.println(SEPARATOR);
		
		//ograniczenie XOR. Uczesntnik wydarzenia moze je organizowac lub w nim uczestniczyc
		System.out.println("Ograniczenie XOR:");
		
        Attendant org = new Attendant("Organizer");
        Attendant par = new Attendant("Participant");

        try {
            org.addAssociationXOR("Organizer", "Organizes", e2);
            System.out.println("New Organizer");
        } catch (XORException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

        try {
            org.addAssociationXOR("Participant", "Participates", e2);
        } catch (XORException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        try {
            par.addAssociationXOR("Participant", "Participates", e2);
            System.out.println("New participant");
        } catch (XORException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        System.out.println(SEPARATOR);
        
        //ograniczenie w³asne. Nazwa uczelni musi zawierac UK w nazwie.
        System.out.println("Ograniczenie Wlasne:");
        
        try {
        	org.setSchool("PL UW");
        } catch (CustomException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        try {
        	par.setSchool("UK Harvard");
        } catch (CustomException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }
        
        System.out.println(SEPARATOR);
        
        //Ograniczenie Subset
        System.out.println("Ograniczenie Subset:");
        
        Racket racket = new Racket("Butterfly");

        try {
            racket.addAssociationSubset(
                    "PLAYER",
                    "USED",
                    "HAS",
                    p1);
        } catch (SubsetException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

        racket.addBinaryAssociation("HAS", "USING", p1);

        try {
            racket.addAssociationSubset(
                    "PLAYER",
                    "USED",
                    "HAS",
                    p1);
            System.out.println("Subset realation added");
        } catch (SubsetException e) {
        	System.out.println("EXCEPTION: " + e.getMessage());
        }

        racket.showAssociationsForRole("HAS", System.out);
        racket.showAssociationsForRole("PLAYER", System.out);
	}
}
