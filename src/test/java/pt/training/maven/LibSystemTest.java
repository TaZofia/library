package pt.training.maven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LibSystemTest {

    private LibSystem library;

    @BeforeEach
    void setUp() {
        library = new LibSystem();
    }

    @Test
    void testAddReader() {
        library.addReader("Alice");
        assertEquals(1, library.getReaders().size(), "Library should have 1 reader.");
        //reset idCounter because in other tests we need start from the beginning
        library.getReaders().get(0).resetReaderIdCounter();
    }

    @Test
    void testAddBook() {
        library.addBook("Xyz", "abc");
        assertEquals(1, library.getBooks().size(), "Library should have 1 book");
    }

    @Test
    void testAddBookCopy() {
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBookCopy("To Kill a Mockingbird");
        Book book = library.findBookByTitle("To Kill a Mockingbird");
        assertNotNull(book, "Book should exist in the library.");
        assertEquals(2, book.getCopies().size(), "Book should have 2 copies.");
    }

    @Test
    void testBorrowBook() {
        library.addBook("1984", "George Orwell");
        library.addReader("Bob");

        Reader reader = library.findReaderById(1);
        library.borrowBook(reader.getReaderId(), "1984");

        assertFalse(reader.getBorrowedBooks().isEmpty(), "Reader should have borrowed one book copy.");
        assertTrue(reader.getBorrowedBooks().get(0).isBorrowed(), "The borrowed book copy should be marked as borrowed.");
        //reset idCounter because in other tests we need start from the beginning
        reader.resetReaderIdCounter();
    }

    @Test
    public void testFindReaderById() {

        library.addReader("xyz");

        // Assuming IDs start at 1, Alice should be reader ID 1, Bob should be reader ID 2
        Reader reader = library.findReaderById(1);
        assertNotNull(reader, "Reader with id=1 should exist");
        assertEquals("xyz",  reader.getLogin());

        Reader otherReader = library.findReaderById(11);
        assertNull(otherReader, "Reader with ID 11 should not exist.");

        //reset idCounter because in other tests we need start from the beginning
        reader.resetReaderIdCounter();
    }

    @Test
    public void testFindBookByTitle() {

        library.addBook("wsx", "aaa");

        Book book = library.findBookByTitle("wsx");
        assertNotNull(book, "Book with title 'wsx' should exist.");
        assertEquals("aaa", book.getAuthor());

        Book otherBook = library.findBookByTitle("Other book");
        assertNull(otherBook, "Book with title 'Other book' should not exist.");
    }
}

