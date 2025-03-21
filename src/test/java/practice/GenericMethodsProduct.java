package practice;

public class GenericMethodsProduct {

	public static void main(String[] args)// calling/caller function 
	{
		//Hardcoding
		//int a=10;
		int prod=mul(10,20);
		System.out.println(prod);
		int v= mul(prod,70);
		System.out.println(v);
		System.out.println(mul(300,400));
				

	}
	
	public static int mul(int a,int b)//called function- Generic Methods-Bussiness logic
	{
		int c=a*b;
		return c;
	}

}
