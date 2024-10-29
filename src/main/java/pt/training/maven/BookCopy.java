package pt.training.maven;

public class BookCopy {
    private static int idCounter = 1;
    private int copyId;
    private boolean isBorrowed;

    public BookCopy() {
        this.copyId = idCounter++;
        this.isBorrowed = false;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public int getCopyId() {
        return copyId;
    }
}
