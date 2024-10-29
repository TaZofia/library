package pt.training.maven;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<BookCopy> copies;

    public Book(String title, String author) {
        this.author = author;
        this.title = title;
        this.copies = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

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
            if(!copies.get(i).isBorrowed())
                return copies.get(i);
        }
        return null;
    }
}


