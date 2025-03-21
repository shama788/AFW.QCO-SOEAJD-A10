package practice;

import genericUtilities.JavaUtility;

public class GenericMethodsPractice {

	public static void main(String[] args) {
		
		//harcoding
		/*int a=10;
		int b=20;
		int c=a+b;
		System.out.println(c);*/
		
		//Call add here
		int sum=add(10,20);
		System.out.println(sum);
		int v= add(sum,70); 
		System.out.println(v);
		System.out.println(add(300,400));
		
		//JavaUtility j=new JavaUtility();
		//System.out.println(j.getSystemDateInFormate());
				
		
		

	}
	
	public static int add(int a,int b) {
		int c=a+b; //result
		return c;
	}

}
