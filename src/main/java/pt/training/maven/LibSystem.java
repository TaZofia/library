package pt.training.maven;

import java.util.ArrayList;
import java.util.List;

public class LibSystem {
    private List<Book> books;
    private List<Reader> readers;

    /**
     * Constructor, creates an array list of all books and readers in system.
     */
    public LibSystem() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    /**
     * Adds copy of a book with a specific title.
     *
     * @param title title of a book which will get a new copy.
     */
    public void addBookCopy(String title) {
        Book book = findBookByTitle(title);
        if(book != null){
            book.addCopy();
            System.out.println("Added copy to " + title);
        } else {
            System.out.println(title + " not found in the system.");
        }
    }

    /**
     * Connects reader with a book.
     *
     * @param readerId id of a reader.
     * @param title title of a book.
     */
    public void borrowBook(int readerId, String title) {
        Reader reader = findReaderById(readerId);       //checking if we have a reader like that
        Book book = findBookByTitle(title);             //checking if we have a book like that

        if (reader == null) {
            System.out.println("Reader with ID " + readerId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book titled '" + title + "' not found.");
            return;
        }

        BookCopy firstAvailableCopy = book.getFirstAvailableCopy();

        if(firstAvailableCopy == null) {
            System.out.println("No available copies of: " + title);
        } else {
            reader.borrowBook(firstAvailableCopy);          //if everything is ok we enable reader to borrow a book
        }
    }

    /**
     * Adds new reader to list od readers.
     *
     * @param login login of a user.
     */
    public void addReader(String login) {
        Reader newReader = new Reader(login);
        readers.add(newReader);
        System.out.println("Added new reader: " + login);
    }

    /**
     * Adds book to the system.
     *
     * @param title title of the book.
     * @param author author.
     */
    public void addBook(String title, String author) {
        Book book = findBookByTitle(title);
        if (book == null) {
            book = new Book(title, author);
            books.add(book);
            book.addCopy();
            System.out.println("Added new book: " + title + " by " + author);
        } else {
            System.out.println(title + " by " + author + " is already in system.");
        }
    }

    public void showReaders() {
        for(int i = 0; i < readers.size(); i++) {
            Reader currentReader = readers.get(i);
            System.out.print("reader ID: " + currentReader.getReaderId() + "\t login: " + currentReader.getLogin());
            System.out.println("\t borrowed books: " + currentReader.getBorrowedBooks());
        }
    }
    /**
     * In a list of already existing books searches for a book with specific title.
     *
     * @param title title of the book.
     * @return a book from a list with specific title.
     */
    private Book findBookByTitle(String title) {
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getTitle().equals(title))
                return books.get(i);
        }
        return null;
    }

    /**
     * In a list of already existing readers searches for a reader with specific id.
     *
     * @param readerId unique id of a user.
     * @return a reader from a list with specific id.
     */
    private Reader findReaderById(int readerId) {
        for(int i = 0; i < readers.size(); i++){
            if(readers.get(i).getReaderId() == (readerId))
                return readers.get(i);
        }
        return null;
    }
}
