package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws hotelNotFoundException {
       List<Hotel> h = new ArrayList<Hotel>();
       h.add(new Hotel(1,"Beta","hotel with beautiful lake view","Swimming pool,Gym,Restaurant",4.5));
       h.add(new Hotel(2,"Alpha","hotel with beautiful forest view","Gym,Restaurant,Parking",3.0));
       h.add(new Hotel(3,"Delta","cosy hotel near the beach","Beach access,Restaurant,Bar",5.0));
       h.add(new Hotel(4,"Zeta","hotel with modern conference facilities","Conference rooms,Restaurant,Parking",4.0));
       h.add(new Hotel(5,"Iota","hotel with historic and classic architecture","Fine dinning,Parking",4.2));

       Scanner sc = new Scanner(System.in);
       int choice = 0;
       while(choice !=4 )
       {
           System.out.println("Welcome to Hotel Management Service");
           System.out.println("Select the service to be performed from the below options");
           System.out.println("1.Sort the Hotel data based on the hotel names.");
           System.out.println("2.Sort the Hotel data based on the hotel ratings.");
           System.out.println("3.Search Hotel by their names.");
           System.out.println("4.Exit");
           System.out.println("Enter your request :\n");
           choice=sc.nextInt();

           switch(choice)
           {
               case 1:
                   HotelService.sortHotelByName(h);
                   System.out.println("Hotels sorted by name: ");
                   for(Hotel hotels : h)
                   {
                       System.out.println(hotels.getHotelName()+" "+hotels.getHotelID()+" "+hotels.getDescription()+" "+hotels.getFacilities()+" "+hotels.getRating());

                   }
                   break;
               case 2:
                   HotelService.sortHotelByRating(h);
                   System.out.println("Hotels sorted by ratings :");
                   for(Hotel hotels : h)
                   {
                       System.out.println(hotels.getRating()+" "+hotels.getHotelName()+" "+hotels.getHotelID()+" "+hotels.getDescription()+" "+hotels.getFacilities());
                   }
                   break;
               case 3:
                   boolean isFound=false;
                   System.out.println("Enter Hotel name : ");
                   String name = sc.next();

                   for(Hotel hotels : h)
                   {
                       if (hotels.getHotelName().equalsIgnoreCase(name))
                       {
                           System.out.println("Hotel Found");
                           System.out.println(hotels.getHotelName()+" "+hotels.getHotelID()+" "+hotels.getDescription()+" "+hotels.getFacilities()+" "+hotels.getRating());
                            isFound = true;
                            break;
                       }

                   }
                   if (isFound==false)
                   {
                       throw new hotelNotFoundException(name);
                   }
                   break;
               case 4:
                   System.out.println("Thank you!!!");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Please select the valid option");
           }

       }

    }
}