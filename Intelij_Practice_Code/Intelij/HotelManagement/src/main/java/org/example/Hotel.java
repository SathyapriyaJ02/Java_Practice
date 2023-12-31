package org.example;
import java.util.*;

class Hotel {
    private int hotelID;
    private String hotelName;
    private String description;
    private String facilities;
    private Double rating;



    Hotel(int hotelID, String hotelName, String description, String facilities, Double rating)
        {
            this.hotelID = hotelID;
            this.hotelName = hotelName;
            this.description = description;
            this.facilities = facilities;
            this.rating = rating;
        }



    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
    public Double getRating()
    {
        return rating;
    }

    public void setRating(Double rating)
    {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", description='" + description + '\'' +
                ", facilities='" + facilities + '\'' +
                ", rating=" + rating +
                '}';
    }
}