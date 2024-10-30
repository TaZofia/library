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
        library.addBookCopy("1984");
        library.addReader("Bob");

        Reader reader = library.findReaderById(1);
        library.borrowBook(reader.getReaderId(), "1984");

        assertFalse(reader.getBorrowedBooks().isEmpty(), "Reader should have borrowed one book copy.");
        assertTrue(reader.getBorrowedBooks().get(0).isBorrowed(), "The borrowed book copy should be marked as borrowed.");
    }

    @Test
    public void testFindReaderById() {

        library.addReader("Alice");
        library.addReader("Bob");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");

        // Assuming IDs start at 1, Alice should be reader ID 1, Bob should be reader ID 2
        Reader reader1 = library.findReaderById(1);
        assertNotNull(reader1, "Reader with ID 1 should exist.");
        assertEquals("Alice", reader1.getLogin(), "Reader with ID 1 should have the login 'Alice'.");

        Reader reader2 = library.findReaderById(2);
        assertNotNull(reader2, "Reader with ID 2 should exist.");
        assertEquals("Bob", reader2.getLogin(), "Reader with ID 2 should have the login 'Bob'.");

        Reader nonExistentReader = library.findReaderById(99);
        assertNull(nonExistentReader, "Reader with ID 99 should not exist.");
    }

    @Test
    public void testFindBookByTitle() {
        library.addReader("Alice");
        library.addReader("Bob");
        library.addBook("1984", "George Orwell");
        library.addBook("Pride and Prejudice", "Jane Austen");

        Book book1 = library.findBookByTitle("1984");
        assertNotNull(book1, "Book with title '1984' should exist.");
        assertEquals("George Orwell", book1.getAuthor(), "Author of '1984' should be George Orwell.");

        Book book2 = library.findBookByTitle("Pride and Prejudice");
        assertNotNull(book2, "Book with title 'Pride and Prejudice' should exist.");
        assertEquals("Jane Austen", book2.getAuthor(), "Author of 'Pride and Prejudice' should be Jane Austen.");

        Book nonExistentBook = library.findBookByTitle("Nonexistent Book");
        assertNull(nonExistentBook, "Book with title 'Nonexistent Book' should not exist.");
    }
}

