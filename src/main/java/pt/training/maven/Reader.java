package pt.training.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for single reader.
 */
public class Reader {
    private static int idCounter = 1;
    final private int readerId;
    final private String login;
    final private List<BookCopy> borrowedBooks;

    /**
     * Constructor, creates a reader with a explicit login.
     *
     * @param login login of a user
     */
    public Reader(String login) {
        this.readerId = idCounter++;
        this.login = login;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Getter.
     *
     * @return readerId
     */
    public int getReaderId(){
        return readerId;
    }

    /**
     * Getter.
     *
     * @return login of a reader
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter.
     *
     * @return list of books which reader borrowed
     */
    public List<BookCopy> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Borrows a copy for a reader.
     *
     * @param copy copy we want to borrow
     */
    public void borrowBook(BookCopy copy) {
        copy.borrow();                  //Borrowing logic encapsulated in BookCopy class (Information Expert)
        borrowedBooks.add(copy);
    }

    /**
     * Resets idCounter by assigning to 1
     */
    public void resetReaderIdCounter() {
        idCounter = 1;
    }
}
