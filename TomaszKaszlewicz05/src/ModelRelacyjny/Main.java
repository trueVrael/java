package ModelRelacyjny;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/*
   
klasy- 4 klasy Osoba, Manager, Kierowca, Firma
asocjacje- klasa Manager-Firma 
dziedziczenie - klasa Osoba, Manager, Kierowca
 */

public class Main {

	public static void main(String[] args) {

		AnnotationConfiguration konfiguracja = new AnnotationConfiguration();
		konfiguracja.addAnnotatedClass(Osoba.class);
		konfiguracja.addAnnotatedClass(Kierowca.class);
		konfiguracja.addAnnotatedClass(Manager.class);

		konfiguracja.configure("hibernate.cfg.xml");

		SessionFactory budowanieSesji = konfiguracja.buildSessionFactory();
		Session tworzSesje = budowanieSesji.getCurrentSession();

		tworzSesje.beginTransaction();

		Kierowca k1 = new Kierowca();
		k1.setImie("Lukasz");
		k1.setNazwisko("Janowski");
		k1.setKategoriaPrawaJazdy("Kategoria A");
		k1.setPensja(5000);
		budowanieSesji.save(k1);

		Firma f1 = new Firma();

		Manager m1 = new Manager();
		m1.setImie("Anna");
		m1.setNazwisko("Kucharska");
		m1.setFirma(f1);
		m1.setStanowisko("Szef");
		budowanieSesji.save(m1);

		budowanieSesji.getTransaction().commit();

	}

}
