package elmhurst;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String [] MyDreamCars= {"BMW Gangstar","Mustang Modified Blue","Range Rover"};
		
		for(int i=0; i<MyDreamCars.length;i++) {
			
			//pause for 4 seconds. waits 4 seconds and then runs the code.
			Thread.sleep(4000);
			
			System.out.println("My dream car:"+MyDreamCars[i]);
		}
		

	}

}
