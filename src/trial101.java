import java.util.Scanner;

public class trial101 
{
	public static String userid(String a)
	{
		int a1 = (int) Math.round(Math.random()*100000);
		String aa = Integer.toString(a1);
		String zz=a+aa;
		return zz;
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name");
		String f = sc.next();
		String s=f.substring(0, 2);
		String fin = userid(s);
		System.out.println("User ID is : "+fin);
		sc.close();
		
	}

}
