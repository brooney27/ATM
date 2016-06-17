
public class DataBase{
	
	private Account[] stored;
	
	public DataBase(){
		stored = new Account[3];
		stored[0] = new Account(1000,1234,456.78);
		stored[1] = new Account(1001,2345,567.89);
		stored[2] = new Account(1002,3456,678.90);
	}
	
	
	public boolean login(int acct, int pin){
		for(int i=0;i<stored.length;i++){
			if(acct==stored[i].getAcct()){
				if(pin==stored[i].getPin())return true;
				return false;
			}
		}
		return false;
	}
	
	public Account lookup(int actnum){
		for(int i=0;i<stored.length;i++){
			if(actnum==stored[i].getAcct())return stored[i];
		}
		return new Account(0,0,0);
	}
}
