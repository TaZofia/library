package pt.training.maven;

public class Filling {
    private LibSystem library;

    public Filling(LibSystem library){
        this.library = library;
    }

    //Adding initial readers (Creator principle)
    public void fill(){
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
