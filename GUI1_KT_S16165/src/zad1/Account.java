package zad1;

public class Account {
	
	private double state;
	private static double interest;
	
	public Account(){
		this.state = 0;
		this.interest = 0;
	}
	public static void setInterestRate(double d) {
		interest = d;
	}

	public void deposit(int x) {
		this.state += x;
	}

	public void transfer(Account destination, int x) {
		destination.state += x;
		this.state -= x;
	}

	public void withdraw(int x) {
		this.state -= x;
		
	}

	public void addInterest() {
		// TODO Auto-generated method stub
		this.state *= (1+(interest/100));
	}
	public double getState() {
		return this.state;
	}

}
