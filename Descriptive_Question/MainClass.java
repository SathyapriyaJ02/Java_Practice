import java.util.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
class MainClass
{
	public static void main(String a[]) throws Exception
	{
	  	
	  	
		List<Song> s = new ArrayList<Song>();
		s.add(Song.createSong("AAA,Pop,04:35,4.5"));
		s.add(Song.createSong("BBB,Melody,03:20,3.5"));
		s.add(Song.createSong("CCC,Rock,05:00,4.7"));
		s.add(Song.createSong("DDD,Pop,02:35,3.0"));
		s.add(Song.createSong("EEE,Melody,04:20,3.5"));
		s.add(Song.createSong("FFF,Rock,05:00,4.7"));
		s.add(Song.createSong("GGG,Pop,05:35,4.2"));
		s.add(Song.createSong("HHH,Melody,04:30,3.5"));
		s.add(Song.createSong("III,Rock,05:00,3.7"));
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		while(choice !=4)
		{
			System.out.println("Welcome to the playlist");
			System.out.println("Select your choice");
			System.out.println("1.Sorting based on duration of the song");
			System.out.println("2.Sorting based on rating of the song");
			System.out.println("3.Search Song");
			System.out.println("4.Exit");
			System.out.println("Enter your request :");
			choice = sc.nextInt();

			switch(choice)
			{
				case 1 :
 					s.sort((s1,s2) -> s1.getDuration().compareTo(s2.getDuration()));
					for(Song i :s)
					{
						System.out.format("%-20s %-10s %-12s %-12s\n",i.getTitle(),i.getGenre(),new SimpleDateFormat("mm:ss").format(i.getDuration()),i.getRating());
					}
					break;	
					
				
				case 2 :
					s.sort((s1,s2) -> s1.getRating().compareTo(s2.getRating()));
					for(Song i :s)
					{
						System.out.format("%-20s %-10s %-12s %-12s\n",i.getTitle(),i.getGenre(),new SimpleDateFormat("mm:ss").format(i.getDuration()),i.getRating());
						
					}
					break;	
					
				case 3 :
					int flag = 0;
					System.out.println("Enter song name : ");
					String name = sc.next();
					
						for(Song i : s)
						{
							if(i.getTitle().equalsIgnoreCase(name))
							{
								System.out.println(i);
								flag = 1;
								try(FileOutputStream fis = new FileOutputStream("file.txt");
								ObjectOutputStream oos = new ObjectOutputStream(fis);)
								{
									oos.writeObject(i);
									System.out.println("Serialization Done");
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
								break;
									
								
							} }
							if(flag == 0)
							{
								throw new songNotFoundException(name);
							}
						
					
					
					break;
				case 4 :
					System.out.println("Thank you !!!");
					System.exit(0);
					break;

				default :
					System.out.println("Please enter valid option.");
					

			}
					
		}
	}

}		
			

	