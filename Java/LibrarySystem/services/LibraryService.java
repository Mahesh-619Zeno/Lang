package LibrarySystem.services;

import LibrarySystem.models.Book;
import LibrarySystem.models.Member;

import java.util.*;

public class LibraryService {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    public void borrowBook(String memberId, String bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book already borrowed.");
            return;
        }

        book.borrow();
        member.borrowBook(bookId);
        System.out.println(member.getName() + " borrowed " + book.getTitle());
    }

    public void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void showMembers() {
        System.out.println("\nLibrary Members:");
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }
}
