package org.example;

public class Book {

    int id;
    String title;
    int borrowCount ;
    boolean isAvailable;

    Book(int id ,String title)
    {
        this.id = id;
        this.title = title;
        this.borrowCount = 0;
        this.isAvailable = true;
    }

    public void borrowBook()
    {
        if(isAvailable)
        {
            isAvailable = false;
            borrowCount++;
        }

    }

    public void returnBook()
    {
        isAvailable = true;
    }

    public int getBorrowCount()
    {
        return borrowCount;
    }


    public String getTitle()
    {
        return title;
    }

    public boolean getIsAvailable()
    {
        return isAvailable;
    }

}
