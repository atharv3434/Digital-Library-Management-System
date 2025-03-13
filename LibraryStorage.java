import java.io.*;
import java.util.*;

public class LibraryStorage {
    private static final String FILE_PATH = "library.txt";

    public static void saveLibrary(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("❌ Error saving library data.");
        }
    }

    public static List<Book> loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
