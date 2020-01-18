package elmhurst;

public class Variable_Types {
	static int myAccountBalance;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		myAccountBalance =100;
		
		if(myAccountBalance>100 & myAccountBalance<1000) {
			System.out.println("You do not have enough balance");
		}
		
		else if(myAccountBalance<=100) {
			System.out.println("You are too poor man!");
		}
		
		else {
			System.out.println("You are rich bro!");
		}
	}

}
