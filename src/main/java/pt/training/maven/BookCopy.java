package pt.training.maven;

/**
 * Class responsible for creating and managing books' copies.
 */
public class BookCopy {
    private static int idCounter = 1;
    private int copyId;
    private boolean isBorrowed;

    /**
     * Constructor.
     */
    public BookCopy() {
        this.copyId = idCounter++;
        this.isBorrowed = false;
    }

    /**
     * Makes copy borrowed.
     */
    public void borrow() {
        isBorrowed = true;
    }

    /**
     * Getter.
     *
     * @return if copy is borrowed or not
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Getter.
     *
     * @return copyId
     */
    public int getCopyId() {
        return copyId;
    }
}
