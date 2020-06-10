package zad1;

public class Main {
	public static void main(String[] args)	{
		Server s;
		try {
			s = new Server(7799);
			new Thread(s).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Client c1 = new Client(7799,"localhost",0,0);
		Thread a =new Thread(c1);
		a.start();
		
		Client c2 = new Client(7799,"localhost",600,0);
		new Thread(c2).start();
	}

}
