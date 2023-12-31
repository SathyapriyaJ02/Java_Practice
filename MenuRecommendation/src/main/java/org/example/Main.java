package org.example;

import java.util.*;
// Definition of MenuItem class
class MenuItem {
    int itemId;
    String displayName;
    int totalRating;
    int numberOfRatings;
    public double getAverageRating() {
        if (numberOfRatings == 0) {
            return 0.0;
        }
        return (double) totalRating / numberOfRatings;
    }
}
// Interface definition
interface IMenuRecommendation {
    void addItem(int itemId, String displayName);
    MenuItem getRecommendedItem();
    void outOfStockItem(int itemId);
    void restockItem(int itemId);
    void makeDealOfTheDayItem(int itemId);
    void rateItem(int itemId, int rating);
}
// Implementation of MenuRecommendation class
class MenuRecommendation implements IMenuRecommendation {
    List<MenuItem> menuItems = new ArrayList<>();
    HashMap<MenuItem,Boolean> availability = new HashMap<>();
    MenuItem special;
    @Override
    public void addItem(int itemId, String displayName) {
        MenuItem menuItem = new MenuItem();
        menuItem.itemId = itemId;
        menuItem.displayName = displayName;
        menuItems.add(menuItem);
        availability.put(menuItem,true);
    }
    @Override
    public MenuItem getRecommendedItem() {
        if(this.special != null && availability.get(special)){
            return special;
        }
        else{
            MenuItem max = null;
            double maxRating = 0;
            for(MenuItem menuItem : menuItems){
                if(menuItem.getAverageRating()>maxRating && availability.get(menuItem)){
                    maxRating = menuItem.getAverageRating();
                    max = menuItem;
                }
            }
            return max;
        }
    }
    @Override
    public void outOfStockItem(int itemId) {
        for(MenuItem menuItem : availability.keySet()){
            if(menuItem.itemId == itemId){
                availability.put(menuItem,false);
                break;
            }
        }
    }
    @Override
    public void restockItem(int itemId) {
        for(MenuItem menuItem : availability.keySet()){
            if(menuItem.itemId == itemId){
                availability.put(menuItem,true);
                break;
            }
        }
    }
    @Override
    public void makeDealOfTheDayItem(int itemId) {
        for(MenuItem menuItem : menuItems){
            if(menuItem.itemId == itemId){
                this.special = menuItem;
                break;
            }
        }
    }
    @Override
    public void rateItem(int itemId, int rating) {
        for(MenuItem menuItem : menuItems){
            if(menuItem.itemId == itemId){
                menuItem.totalRating = menuItem.totalRating+rating;
                menuItem.numberOfRatings++;
                break;
            }
        }
    }
}
// Driver code
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumberOfRequests = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        IMenuRecommendation menuRecommendation = new MenuRecommendation();
        for (int i = 0; i < totalNumberOfRequests; i++) {
            String request = scanner.nextLine();
            String[] tokens = request.split(" ");
            switch (tokens[0]) {
                case "addItem":
                    menuRecommendation.addItem(Integer.parseInt(tokens[1]), tokens[2]);
                    break;
                case "getRecommendedItem":
                    MenuItem recommendedItem = menuRecommendation.getRecommendedItem();
                    if (recommendedItem != null) {
                        System.out.println(recommendedItem.itemId + " " + recommendedItem.displayName +
                                " Rating: " + recommendedItem.getAverageRating());
                    } else {
                        System.out.println("N/A");
                    }
                    break;
                case "outOfStockItem":
                    menuRecommendation.outOfStockItem(Integer.parseInt(tokens[1]));
                    break;
                case "restockItem":
                    menuRecommendation.restockItem(Integer.parseInt(tokens[1]));
                    break;
                case "makeDealOfTheDayItem":
                    menuRecommendation.makeDealOfTheDayItem(Integer.parseInt(tokens[1]));
                    break;
                case "rateItem":
                    menuRecommendation.rateItem(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
            }
        }
    }
}