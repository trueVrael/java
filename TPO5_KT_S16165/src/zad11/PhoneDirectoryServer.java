package zad11;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class PhoneDirectoryServer {
	public static void main(String[] args)
	{
		try{
			Properties prop = new Properties();
			prop.setProperty("java.naming.provider.url", System.getenv("java.naming.provider.url"));
			prop.setProperty("java.naming.factory.initial", System.getenv("java.naming.factory.initial"));
			Context ctx = new InitialContext(prop);
			PhoneDirectory phonebook = new PhoneDirectory("PhoneBook.txt");
			ctx.rebind("PhoneDirectoryService", phonebook);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
