package foodagg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	public static void main(String a[]) throws SQLException
	{
		Item item =new Item();
		ItemDAO dao = new ItemDAO();
		try
		{
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("success");
			System.out.println("Welcome to Food Database");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
	     }
		catch(Exception e)
		{
			System.out.println(e);
		}
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while(choice !=5)
		{
			System.out.println("1.Add single item\n2.Add multiple items\n3.Display items based on given type\n4.Display items based on given price\n5.Exit");
			System.out.println("what's your choice??");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.print("Enter name,price,type: ");
					dao.addItem((Item.inputItem(sc.next())));
					break;
					
				case 2:
					List<Item> itemList = new ArrayList<>();
					System.out.print("Enter how many items to be added:");
					int n = sc.nextInt();
					for(int i=0;i<n;i++)
					{
						System.out.println((i+1)+"Enter name,price,type");
						itemList.add(item.inputItem(sc.next()));
					}
					dao.bulkCopy(itemList);
					break;
					
				case 3:
					System.out.println("Enter type of food to search");
					String t = sc.next();
					List<Item> type = dao.findItem(t);
					dao.disp(type);
					break;
					
				case 4:
					System.out.println("Enter price of food to search");
					Double p = sc.nextDouble();
					List<Item> price = dao.findItem(p);
					dao.disp(price);
					break;
					
				case 5:
					System.out.println("Thank you :)");
					System.exit(1);
					break;
				default:
					System.out.println("Invalid option");
					break;
				
			}
		}
	}
}
