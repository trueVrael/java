package app;

import classes.ObjectPlus;
import classes.ObjectPlusPlus;

import java.time.LocalDate;

import People.Coach;
import People.Person;
import People.Player;
import People.PlayingCoach;
import GameObject.PlayerCharacter;
import GameObject.PlayerCharacterType;
import Health.*;
import Events.*;

/*
 dziedziczenie
 
 Disjoint
 Klasa abstrakcyjna (People.Person)
 Polimorficzne wo³anie metody
 Overlapping
 Wielodziedziczenie (People:Player+Coach -> PlayingCoach)
 Wieloaspektowe
 Dynamiczne
 
 */

public class Main {
	
	private static final String SEPARATOR = "---------------------------------------------------------------------------------------";
	
	public static void main(String[] args) {
	    
	    /*
	     *  Disjoint
	     *  Turnieje mo¿emy podzieli na ró¿ne kategorie, które nei mog¹ na siebie zachodzic.
	     *  W przykladzie Olimpiada i liga mistrzow. Turniej nie mo¿e byc jednoczesnie jednym i drugim.
	     *  Nadklase turniej mozemy uzywac do przechowywania informacji o jakis pomniejszych lokalnych wydarzeniach, ktore nie maja nazwy
	     */
		
		System.out.println("Disjoint");
		
		Olympics e1 = new Olympics(10000000, "Tokyo");
		ChampionsLeague e2 = new ChampionsLeague(5000, "Bogoria Grodzisk");
		Tournament e3 = new Tournament(100, "local");
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		System.out.println(SEPARATOR);
		
	    // Klasa abstrakcyjna Person. Dziedziczy po niej Player i Coach
	    Person p1 = new Player(
	    		new Person.PersonBuilder()
	    				.firstName("Timo")
	    				.lastName("Boll")
	    				.pesel("81030825481")
	    				.health(new Healthy()),
	    		"left", 20000);  
	    Player p2 = new Player(
	    		new Person.PersonBuilder()
	    				.firstName("Andrzej")
	    				.lastName("Grubba")
	    				.pesel("58051472109")
	    				.health(new Healthy()),
	    		"right", 500000);
	    Person c1 = new Coach(
	    		new Person.PersonBuilder()
	    				.firstName("Ryusuke")
	    				.lastName("Sakamoto")
	    				.pesel("84112586007")
	    				.health(new Healthy()),
	    		"regional", 3000);   
	    Coach c2 = new Coach(
	    		new Person.PersonBuilder()
	    				.firstName("Jorg")
	    				.lastName("Roskopff")
	    				.pesel("69052254213")
	    				.health(new Healthy()),
	    		"national", 6000);

	    
	    p1.addBinaryAssociation("Coaches", "Players", c1);
	    p1.addBinaryAssociation("Coaches", "Players", c2);
	    p2.addBinaryAssociation("Coaches", "Players", c2);
	    
	    /*
	     *  Polimorficzne wo³anie metod.
	     *  Dochod zawodnikow to wygrane z turniei
	     *  Trenerzy otrzymuja pensje
	     *  Trenerzy zawodnicy otrzymuja wygrane i pensje (pokazane w pozniejszym przykladzie)
	     */
	    System.out.println("Polimorfizm");
	    
	    System.out.println("Players income (tournament prizes):");
	    System.out.println(p1.getIncome());
	    System.out.println(p2.getIncome());
	    System.out.println("Coaches income (salary):");
	    System.out.println(c1.getIncome());
	    System.out.println(c2.getIncome());
	    
	    System.out.println(SEPARATOR);
	    
	    // Overlapping, PlayerCharacter (nazywany potworem) moze miec dowolna liczbe typow
	    System.out.println("Overlapping");
	    
	    PlayerCharacter monster = new PlayerCharacter(2,10);
	    System.out.format("Na poczatku typ potwora to: %s%n", monster.getType().toString());
	    monster.evolve(PlayerCharacterType.FIRE);
	    System.out.format("Po ewolucji otrzymujemy dodatkowy typ: %s%n", monster.getType().toString());
	    monster.evolve(PlayerCharacterType.ICE);
	    System.out.format("Po kolejnej ewolucji otrzymujemy dodatkowy typ: %s%n", monster.getType().toString());
	    monster.lose(PlayerCharacterType.NEUTRAL);
	    System.out.format("Po utracie mocy tracimy jeden typ: %s%n", monster.getType().toString());
	    
	    System.out.println(SEPARATOR);
	    
	    /*
	     *  Wielodziedziczenie Klasa Playing Coach dziedziczy po klasie Player i klasie Coach.
	     *  Jest to zadki przypadek kiedy zawodnik nie konczy kariery, lecz zaczyna prace rowniez jako trener
	     */
	    System.out.println("Wielodziedziczenie");
	    
	    PlayingCoach pc = new PlayingCoach(
	    					new Person.PersonBuilder()
	    					.firstName("Zbigniew")
	    					.lastName("Grzalka")
	    					.pesel("82012667489"),
	    					"regional", 5000, "Right", 50000);
	    
	    System.out.println(pc);
	    System.out.println(pc.getIncome());
	    pc.prepare();
	    pc.appointment();
	    
	    System.out.println(SEPARATOR);
	    
	    // Wieloaspektowe, pierwszy aspekt to wykonywany zawod osoby, a drugi aspekt to stan jej zdrowia
	    System.out.println("Wieloaspektowe");
	    
	    pc.setHealth(new Injured(10));
	    System.out.println("Aspekt 1: zawod");
	    pc.appointment();
	    p2.prepare();
	    pc.appointment();
	    System.out.println("Aspekt 2: zdrowie");
	    System.out.println(pc.getPersonStatus());
	    System.out.println(p2.getPersonStatus());
	    
	    System.out.println(SEPARATOR);
	    
	    // Dynamiczne, czesty przypadek gdy zawodnik po zakonczeniu kariery zostaje trenerem i przestaje pracowac jako zawodnik
	    System.out.println("Wieloaspektowe");
	    
	    System.out.println(p1.showClass());
	    p1 = new Coach(p1,"national", 10000);
	    System.out.println(p1.showClass());
	    
	    System.out.println(SEPARATOR);
	}
}
