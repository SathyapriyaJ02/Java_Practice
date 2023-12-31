package org.example;

public class Main {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();


        library.addBook(1, "1984");
        library.registerUser(1, "Alice");

        library.addBook(2, "1985");
        library.registerUser(2, "Sathya");


        library.borrowBook(1, 1);

        library.returnBook(1, 1);

        library.borrowBook(1, 1);

        Book popularBook = library.getMostPopluarBook();
        if (popularBook != null) {
            System.out.println("Most Popular Book: " + popularBook.getTitle() + " "+"BorrowCount :"+popularBook.getBorrowCount());

        } else {
            System.out.println("No Popular Book");
        }

    }
}