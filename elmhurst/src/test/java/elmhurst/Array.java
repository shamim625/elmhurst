package elmhurst;

public class Array {

	public static void main(String[] args) {
		
		int[] abc= new int[5];
		
		abc[0]=7;
		abc[1]=3;
		abc[2]=9;
		abc[3]=5;
		abc[4]=1;
		
		
		
		for(int i=0; i<abc.length;i++) {
			System.out.println("Each Number Number:"+abc[i]);
		}
		
		String[] smarttech=new String[5];
		smarttech[0]= "Shamim";
		smarttech[1]="Rakib";
		smarttech[2]="Ayan";
		smarttech[3]="Oli";
		smarttech[4]="Mia";
		
		System.out.println("Smarttech How Many Students:"+smarttech.length);
		
		for(int i=0; i<smarttech.length;i++) {
			System.out.println("Smarttech Students:"+smarttech[i]);
			
		}
		
		//Multidimentional Array
		
//		int[][] two= new int [1][1];
//		two[0][0]=40;
//		two[0][1]=20;
//		two[1][0]=5
//		two[1][1]=10;
//		
//		for(int i=0; i<two.length;i++) {
//			for(int j=0; j<two[i].length;j++) {
//			System.out.println("age of smarttech students:"+two[i][j]);
//			}
//				System.out.println();
//		}
		
        int[] a= new int [5];
		
		a[0]=52;
		a[1]= 36;
		a[2]=29;
		a[3]=45;
		
		for(int i=0; i<a.length;i=i+2) {
			System.out.println("The value of a:"+a[i]);
		}
		
		String[] best= new String[2];
		
		best[0]= "Pankaj";
		best[1]= "Shamim";
		
		for(int i=0; i<best.length; i++) {
			System.out.println("Best Student:"+best[i]);
		}
		
		//Advance for loop
		for(String bro:best) {
			System.out.println("Bestie:"+bro);
		}
		
		int[][]  chicken= new int[2][4];
		chicken[0][0]=26;
		chicken[0][1]=25;
		chicken[0][2]=45;
		chicken[0][3]=38;
		chicken[1][0]=89;
		chicken[1][1]=28;
		chicken[1][2]=5;
		chicken[1][3]=1000;
		
		//for(int i=0; i<chicken.length;i++) {
			System.out.println("Required Number:"+chicken[0][3]);
			System.out.println("Required Number:"+chicken[1][1]);
		//}
		
		
		
		
		
		}
	

	}


