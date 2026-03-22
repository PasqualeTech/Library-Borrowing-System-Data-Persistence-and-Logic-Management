import java.util.*;
import java.io.*;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", (isAvailable ? "Disponibile" : "In Prestito"), title, author);
    }

    public String toFileFormat() {
        return title + "," + author + "," + isAvailable;
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private final String FILE_NAME = "library_data.txt";

    public void addBook(Book b) {
        books.add(b);
        saveToFile();
    }

    public void showBooks() {
        if (books.isEmpty()) System.out.println("Biblioteca vuota.");
        else books.forEach(System.out::println);
    }

    public boolean borrowBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title) && b.isAvailable()) {
                b.setAvailable(false);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    private void saveToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) out.println(b.toFileFormat());
        } catch (IOException e) {
            System.out.println("Errore salvataggio: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                String[] data = fs.nextLine().split(",");
                books.add(new Book(data[0], data[1], Boolean.parseBoolean(data[2])));
            }
        } catch (Exception e) {
            System.out.println("Errore caricamento.");
        }
    }
}

public class LibrarySystemApp {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.loadFromFile();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Aggiungi 2.Lista 3.Presta 4.Esci");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Titolo: "); String t = sc.nextLine();
                    System.out.print("Autore: "); String a = sc.nextLine();
                    manager.addBook(new Book(t, a, true));
                }
                case 2 -> manager.showBooks();
                case 3 -> {
                    System.out.print("Titolo da prestare: ");
                    if (manager.borrowBook(sc.nextLine())) System.out.println("Libro prestato!");
                    else System.out.println("Non disponibile.");
                }
            }
        } while (choice != 4);
    }
}
