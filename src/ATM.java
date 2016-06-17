import java.util.Scanner;

public class ATM {
	public static void session(){
		Scanner in = new Scanner(System.in);
		DataBase data = new DataBase();
		
		int actnum = 0;
		int pin;
		int tries = 0;
		boolean valid = false;
		
		//login
		while(!valid){
			System.out.println("Enter Account Number: ");
			actnum = in.nextInt();
			System.out.println("Enter PIN: ");
			pin = in.nextInt();
			if(data.login(actnum,pin)) valid=true;
			else{
				tries++;
				in.nextLine();
			}
			if(tries==3){
				System.out.println("Too many attempts, account locked");
				in.close();
				return;
			}
		}
		
		//Login Success
		in.nextLine();
		
		Account user = data.lookup(actnum);
		
		boolean receipt=false;
		System.out.println("Login successful");
		System.out.println("Would you like a receipt with your transaction? (y/n)");
		String input = in.nextLine();
		
		//transaction selection
		if(input.equals("y"))receipt=true;
		System.out.println("Press 1 to check your balance.");
		System.out.println("Press 2 to make a withdrawal.");
		System.out.println("Press 3 to make a deposit.");
		int transaction = in.nextInt();
		
		//Check Balance
		if(transaction==1){
			System.out.println("Current balance: " + user.getBalance());
			in.close();
			return;
		}
		
		//Withdraw
		else if(transaction==2){
			System.out.println("Enter withdrawal amount: ");
			int amt = in.nextInt();
			if(amt>user.getBalance()){
				System.out.println("Insufficient funds");
				in.close();
				return;
			}
			user.withdraw(amt);
			System.out.println("Withdrawal approved");
			if(receipt)System.out.println("Withdrew " + amt + ". Current balance: " + user.getBalance());
			in.close();
			return;
		}
		
		//Deposit
		else if(transaction==3){
			System.out.println("Enter withdrawal amount: ");
			int amt = in.nextInt();
			
			user.deposit(amt);
			System.out.println("Deposit Complete");
			if(receipt)System.out.println("Deposited " + amt + ". Current balance: " + user.getBalance());
			in.close();
			return;
		}
		in.close();
		
	}
}
