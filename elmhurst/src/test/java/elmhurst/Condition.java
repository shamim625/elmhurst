package elmhurst;

public class Condition {

	static int Grade;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Grade= 70;
		
		if(Grade>90 & Grade<=100) {
			System.out.println("A");
		}
		
		else if(Grade<90 & Grade>80) {
			System.out.println("B");
	
		}
		
		else {
			System.out.println("C");
		}
	}

}
