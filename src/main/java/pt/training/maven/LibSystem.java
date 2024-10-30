package pt.training.maven;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for managing all the actions in the library system.
 */
public class LibSystem {
    private List<Book> books;       //Creates the core library system (Creator principle)
    private List<Reader> readers;   //Initializes library data (Creator principle)

    /**
     * Constructor, creates an array list of all books and readers in the system.
     */
    public LibSystem() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    //High cohesion: Keeps all book-related data and operations within the LibSystem.

    /**
     * Getter.
     *
     * @return list of books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Getter.
     *
     * @return list of readers
     */
    public List<Reader> getReaders() {
        return readers;
    }

    /**
     * Adds copy of a book with a explicit title.
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
        Reader reader = findReaderById(readerId);       //checking if we have a reader like that (Information Expert)
        Book book = findBookByTitle(title);             //checking if we have a book like that (Information Expert)

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
            reader.borrowBook(firstAvailableCopy);          //Low coupling: directly assigns the copy to the reader
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
        System.out.println("************* nr id: " + newReader.getReaderId());
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

    /**
     * Show all readers who are in system with borrowed copies.
     */
    public void showReaders() {
        for(int i = 0; i < readers.size(); i++) {
            Reader currentReader = readers.get(i);
            System.out.print("reader ID: " + currentReader.getReaderId() + "\t login: " + currentReader.getLogin());
            System.out.print("\t borrowed books: " );
            for(int j = 0; j < currentReader.getBorrowedBooks().size(); j++){
                System.out.print(currentReader.getBorrowedBooks().get(j).getCopyId() + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Shows all books which are in system with authors and all books' copies
     */
    public void showBooks(){
        for(int i = 0; i < books.size(); i++){
            Book currentBook = books.get(i);
            System.out.print("book title: " + currentBook.getTitle() + "\t author: " + currentBook.getAuthor());
            System.out.print("\t all copies: ");
            for(int j = 0; j < currentBook.getCopies().size(); j++){
                System.out.print(currentBook.getCopies().get(j).getCopyId() + ", ");
            }
            System.out.println();
        }
    }

    /**
     * In a list of already existing books searches for a book with explicit title.
     *
     * @param title title of the book.
     * @return a book from a list with explicit title.
     */
    public Book findBookByTitle(String title) {
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getTitle().equals(title))
                return books.get(i);
        }
        return null;
    }

    /**
     * In a list of already existing readers searches for a reader with unique id.
     *
     * @param readerId unique id of a user.
     * @return a reader from a list with unique id.
     */
    public Reader findReaderById(int readerId) {
        for(int i = 0; i < readers.size(); i++){
            if(readers.get(i).getReaderId() == readerId)
                return readers.get(i);
        }
        return null;
    }
}
