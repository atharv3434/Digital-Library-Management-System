import java.util.Scanner;

public class LibraryApp {
    private static LibraryManager libraryManager = new LibraryManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📕 Welcome to Digital Library Management System 📕");

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. View Borrowed Books");
            System.out.println("7. Delete Book");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    libraryManager.addBook();
                    break;
                case 2:
                    libraryManager.searchBook();
                    break;
                case 3:
                    libraryManager.borrowBook();
                    break;
                case 4:
                    libraryManager.returnBook();
                    break;
                case 5:
                    libraryManager.viewAvailableBooks();
                    break;
                case 6:
                    libraryManager.viewBorrowedBooks();
                    break;
                case 7:
                    libraryManager.deleteBook();
                    break;
                case 8:
                    System.out.println("Exiting... Keep Reading! 📚");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
