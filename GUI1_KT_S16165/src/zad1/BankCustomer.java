package zad1;

public class BankCustomer extends Person{
	
	private Account account;
	
	public BankCustomer(Person person) {
		super(person.getName());
		this.account = new Account();	
	}

	public Account getAccount() {
		return this.account;
	}
	
	@Override
	public String toString() {
		return ("Klient: "+ this.getName() +" stan konta " + this.account.getState());
	}
}
