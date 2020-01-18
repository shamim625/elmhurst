package elmhurst;

public class ForeloopTest {
	
	public static void main(String[] args) {
		
		int i;
		for(i=0; i<=10; i++) {
			System.out.println("value of i: "+i);
		
		}
		
		for(i=10; i>=0; i--) {
			System.out.println("value of i:"+i);
		}
		
		for(i=0; i<=10; i= i+2) {
			System.out.println("value of i:"+i);
		}
		
			
		for(i=10; i>=0; i= i-2) {
				System.out.println("value of i:"+i);
			}
		
		for(i=100; i>=0; i= i-5) {
			System.out.println("value of i:"+i);
		}
		
		for(i=100; i>=0; i=i-5) {
			System.out.println("value of i:"+i);
		}
		
		String[] cars= {"BMW i8", "Audi R8", "Mustang"};
		for(String r: cars) {
			System.out.println(r);
		}
		
		String[] students= {"Shamim", "Oli", "Rakib"};
		for(String s: students) {
			System.out.println(s);
		}
		
		//String[] animal= {
		
		
		
		
		
		
		
	}

}

