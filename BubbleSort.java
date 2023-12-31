package PracticePackage ;
import java.util.*;
class BubbleSort
{
	
	public static void main(String args[])
	{
			
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of array:");
		int a = sc.nextInt();
		int temp;
		System.out.println("Enter the numbers:");
		int[] arr = new int[a];
		for(int i=0;i<a;i++)
		{
		    arr[i]=sc.nextInt();
		}
		for(int i=0;i<a-1;i++)
		{
		    
		    for(int j=0;j<a-i-1;j++)
		    {
		        if (arr[j]>arr[j+1]){
		            temp=arr[j];
		            arr[j]=arr[j+1];
		            arr[j+1]=temp;
		        }
		    }
		}
		System.out.println("The Sorted Array is");
		for(int i=0;i<a;i++)
		{
		    System.out.println(arr[i]);
		}
		
	}	
}



