package org.example;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagement {

    Map<Integer,Book> books = new HashMap<>();
    Map<Integer,User>  user = new HashMap<>();

    public LibraryManagement()
    {

    }
    public void addBook(int id , String name)
    {
        books.put(id,new Book(id,name));

        for(Map.Entry<Integer,Book> book : books.entrySet())
        {
            int key = book.getKey();
            String title = book.getValue().getTitle();
            int borrowCount = book.getValue().getBorrowCount();
            boolean available = book.getValue().getIsAvailable();

            System.out.println(key+" "+title+" "+borrowCount+" "+available);
        }
    }

    public void registerUser(int id , String name)
    {
        user.put(id,new User(id,name));
    }

    public void borrowBook(int userId , int bookId)
    {
        if(books.containsKey(bookId) && user.containsKey(userId))
        {
            books.get(bookId).borrowBook();
        }

    }

    public void returnBook(int userId , int bookId)
    {
        if(books.containsKey(bookId) && user.containsKey(userId))
        {
            books.get(bookId).returnBook();
        }

    }
    public Book getMostPopluarBook()
    {
        return books.values().stream().max((b1,b2)->Integer.compare(b1.getBorrowCount(),b2.getBorrowCount())).orElse(null);
    }


}
