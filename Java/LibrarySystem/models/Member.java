package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private List<String> borrowedBooks;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<String> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
    }

    @Override
    public String toString() {
        return id + " - " + name + " (Borrowed: " + borrowedBooks + ")";
    }
}
