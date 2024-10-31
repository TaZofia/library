package pt.training.maven;

/**
 * Class responsible for initializing data.
 */
public class Filling {
    final private LibSystem library;

    /**
     * Constructor.
     *
     * @param library object of LibSystem
     */
    public Filling(final LibSystem library) {
        this.library = library;
    }

    //Adding initial readers (Creator principle)

    /**
     * Method with calls of other methods to add data.
     */
    public void fill() {
        library.addReader("John");
        library.addReader("Ben");
        library.addReader("Julia");

        library.addBook("1984", "George Orwell");
        library.addBookCopy("1984");

        library.addBook("Gone with the wind", "Margaret Mitchell");
        library.addBookCopy("Gone with the wind");
        library.addBookCopy("Gone with the wind");

        library.addBook("Pride and prejudice", "Jane Austen");
    }
}
