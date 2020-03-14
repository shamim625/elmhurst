package Polymorphism;

public class OverloadTest {

    public void getsalary(int a) {
	
	System.out.println(a);
    }
	
	public void getsalary(int a, int b) {
		
		System.out.println(a+b);
		
}

	public void getSalary(int a, int b, int c) {
		
		System.out.println(a+b+c);
	}
	

}
