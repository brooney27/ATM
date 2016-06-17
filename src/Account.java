
public class Account {
	private int acct;
	private int pin;
	private double balance;
	
	public Account(int ac, int pi, double bal){
		acct = ac;
		pin = pi;
		balance = bal;
	}
	
	public int getAcct(){
		return acct;
	}
	public int getPin(){
		return pin;
	}
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amt){
		balance+=amt;
	}
	public void withdraw(double amt){
		balance-=amt;
	}
}
