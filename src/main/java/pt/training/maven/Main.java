package pt.training.maven;

import java.util.Scanner;

/**
 * Main class of a program.
 */
public class Main {

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        final LibSystem library = new LibSystem();
        final Filling filling = new Filling(library);
        filling.fill();

        final Scanner scanner = new Scanner(System.in);

        while(true) {
            //Display user options
            System.out.println();
            System.out.println("1. Add copy");
            System.out.println("2. Add a reader");
            System.out.println("3. Add a book");
            System.out.println("4. Borrow a copy for a specific user");
            System.out.println("5. Show readers");
            System.out.println("6. Show books");
            System.out.print("Enter command: ");

            final int command = scanner.nextInt();
            scanner.nextLine();

            // Following Controller principle: Main directs user commands to appropriate methods in LibSystem
            switch (command) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    library.addBookCopy(title);         //Low coupling: Main does not directly manipulate Book or BookCopy class
                    break;
                case 2:
                    System.out.print("Enter login of a reader: ");
                    String login = scanner.nextLine();
                    library.addReader(login);
                    break;
                case 3:
                    System.out.print("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(bookTitle, author);
                    break;
                case 4:
                    System.out.print("Enter title of the book: ");
                    String bTitle = scanner.nextLine();
                    System.out.print("Enter reader ID: ");
                    int readerId = scanner.nextInt();
                    library.borrowBook(readerId, bTitle);
                    break;
                case 5:
                    library.showReaders();
                    break;
                case 6:
                    library.showBooks();
                    break;
                default:
                    System.out.println("Invalid command, try again.");
            }
        }
    }
}
