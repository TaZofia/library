package pt.training.maven;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    private static int idCounter = 1;
    private int readerId;
    private String login;
    private List<BookCopy> borrowedBooks;

    public Reader(String login) {
        this.readerId = idCounter++;
        this.login = login;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getReaderId(){
        return readerId;
    }

    public String getLogin() {
        return login;
    }

    public List<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(BookCopy copy) {
        borrowedBooks.add(copy);
        copy.borrow();
    }

}
