package LibrarySystem;

import LibrarySystem.models.Book;
import LibrarySystem.models.Member;
import LibrarySystem.services.LibraryService;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        // Add books
        library.addBook(new Book("101", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("102", "Clean Code", "Robert C. Martin"));

        // Add members
        library.addMember(new Member("M01", "Alice"));
        library.addMember(new Member("M02", "Bob"));

        // Borrow book
        library.borrowBook("M01", "101");

        // Show details
        library.showBooks();
        library.showMembers();
    }
}
