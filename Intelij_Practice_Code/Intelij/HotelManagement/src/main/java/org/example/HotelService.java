package org.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class HotelService {
    public static void sortHotelByName(List<Hotel> h) {
        h.sort(new Comparator<Hotel>() {
            @Override
            public int compare(Hotel h1, Hotel h2) {
                return h1.getHotelName().compareTo(h2.getHotelName());
            }
        });

    }


    public static void sortHotelByRating(List<Hotel> h)
    {
       h.sort(new Comparator<Hotel>()
       {
           @Override
           public int compare(Hotel h1, Hotel h2)
           {
               if(h1.getRating()> h2.getRating())
               {
                   return -1;
               }
               else if (h1.getRating()<h2.getRating())
               {
                   return 1;
               }
               else
               {
                   return 0;
               }
           }
       });

    }

    }
