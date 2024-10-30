package pt.training.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents single book.
 */
public class Book {
    final private String title;
    final private String author;
    final private List<BookCopy> copies;

    /**
     * Constructor, creates a book with a unique title and with explicit author.
     *
     * @param title title of a book
     * @param author author
     */
    public Book(String title, String author) {
        this.author = author;
        this.title = title;
        this.copies = new ArrayList<>();
    }

    /**
     * Getter.
     *
     * @return book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter.
     *
     * @return book's author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Getter.
     *
     * @return list of copies of explicit book
     */
    public List<BookCopy> getCopies() {
        return copies;
    }

    /**
     * Creates another copy of an explicit book.
     */
    public void addCopy() {
        copies.add(new BookCopy());
    }

    /**
     * Searching for a copy of a specific book which is not borrowed by anyone.
     *
     * @return BookCopy which is not borrowed by anyone
     */
    public BookCopy getFirstAvailableCopy() {
        for(int i = 0; i < copies.size(); i++) {
            if(!copies.get(i).isBorrowed()) {
                return copies.get(i);
            }
        }
        return null;
    }
}


