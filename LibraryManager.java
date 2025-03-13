import java.util.*;

public class LibraryManager {
    private List<Book> books;
    private Scanner sc;

    public LibraryManager() {
        this.books = LibraryStorage.loadLibrary();
        this.sc = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        books.add(new Book(title, author));
        LibraryStorage.saveLibrary(books);
        System.out.println("✅ Book Added Successfully!");
    }

    public void searchBook() {
        System.out.print("Enter book title or author to search: ");
        String query = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query)) {
                System.out.println("\n🔍 Found Book:");
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No books found.");
        }
    }

    public void borrowBook() {
        viewAvailableBooks();
        System.out.print("Enter book number to borrow: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < books.size() && !books.get(index).isBorrowed()) {
            books.get(index).borrowBook();
            LibraryStorage.saveLibrary(books);
            System.out.println("📚 Book Borrowed Successfully!");
        } else {
            System.out.println("❌ Invalid selection or book already borrowed.");
        }
    }

    public void returnBook() {
        viewBorrowedBooks();
        System.out.print("Enter book number to return: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < books.size() && books.get(index).isBorrowed()) {
            books.get(index).returnBook();
            LibraryStorage.saveLibrary(books);
            System.out.println("✅ Book Returned Successfully!");
        } else {
            System.out.println("❌ Invalid selection or book is not borrowed.");
        }
    }

    public void viewAvailableBooks() {
        System.out.println("\n📗 Available Books:");
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isBorrowed()) {
                System.out.println((i + 1) + ". " + books.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("📄 No available books.");
        }
    }

    public void viewBorrowedBooks() {
        System.out.println("\n📕 Borrowed Books:");
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBorrowed()) {
                System.out.println((i + 1) + ". " + books.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("📄 No borrowed books.");
        }
    }

    public void deleteBook() {
        viewAvailableBooks();
        System.out.print("Enter book number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < books.size() && !books.get(index).isBorrowed()) {
            books.remove(index);
            LibraryStorage.saveLibrary(books);
            System.out.println("✅ Book Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid selection or borrowed book cannot be deleted.");
        }
    }
}
