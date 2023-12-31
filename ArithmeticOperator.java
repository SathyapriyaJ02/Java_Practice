package PracticePackage;
import java.util.*;
import java.util.Scanner;

class ArithmeticOperator
{
	public static void main(String a[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the numbers");
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		String opr = s.next();
		
		
		switch(opr)
		{
			case "+" : System.out.println("The sum is "+(num1+num2));break;
			case "-" : System.out.println("The Diff is "+(num1-num2));break;
			case "*" : System.out.println("The Mul is "+(num1*num2));break;
			case "/" : System.out.println("The Div is "+(num1/num2));break;
			case "%" : System.out.println("The Mod is "+(num1%num2));break;
			default : System.out.println("Invalid Input");
		}
	}
}