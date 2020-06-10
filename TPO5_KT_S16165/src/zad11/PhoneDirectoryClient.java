package zad11;

import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class PhoneDirectoryClient {
	public static void main(String[] args)
	{
		try
		{
			boolean working;
			Properties prop = new Properties();
			prop.setProperty("java.naming.provider.url", System.getenv("java.naming.provider.url"));
			prop.setProperty("java.naming.factory.initial", System.getenv("java.naming.factory.initial"));
			Context ctx = new InitialContext(prop);
			Object objref = ctx.lookup("PhoneDirectoryService");
			PhoneDirectoryInterface tmp;
			tmp = (PhoneDirectoryInterface) PortableRemoteObject.narrow(objref, PhoneDirectoryInterface.class);
			try(Scanner sc = new Scanner(System.in)){
				working = true;
				while(working)
				{
					System.out.println("Dostępne komendy(get, add, replace(nie zaimplementowana), bye)");
					String[] input = sc.nextLine().split(" ");
					
					if(input[0].equals("get")){
						if(input.length!=2)
							System.out.println("Zła liczba argumentów");
						else{
							String res = tmp.getNr(input[1]);
							if(res==null)
								System.out.println("Dana osoba nie znajduję się w książce telefonicznej");
							else
								System.out.println(res);
						}
					}
					else if(input[0].equals("add")){
						if(input.length!=2)
							System.out.println("Zła liczba argumentów");
						else
						{
							boolean ok = tmp.addNr(input[1], input[2]);
							if(ok)
								System.out.println("Podana osoba została dodana: " + input[1] + ' ' + input[2]);
							else
								System.out.println("Nie można zapisać tej samej osoby dwa razy");
						}
					}
					else if(input[0].equals("replace")){
						if(input.length!=2)
							System.out.println("Zła liczba argumentów");
						else{
							boolean ok = tmp.replaceNr(input[1], input[2]);
							if(ok)
								System.out.println("Zmieniono dane osoby: " + input[1] + ' ' + input[2]);
							else
								System.out.println("Brak danych o podanej osobie w książce");
						}
					}
					else if(input[0].equals("bye"))
						working=false;
				}				
			}					
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
