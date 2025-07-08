import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public List<Book> removeOutdatedBooks(int yearsThreshold) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();
        int currentYear = java.time.Year.now().getValue();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getYear() < currentYear - yearsThreshold) {
                removedBooks.add(book);
                iterator.remove();
            }
        }
        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                if (!book.isForSale()) {
                    throw new IllegalArgumentException("Quantum book store: Book is not for sale.");
                }
                if (book instanceof PaperBook) {
                    PaperBook pb = (PaperBook) book;
                    if (pb.getStock() < quantity) {
                        throw new IllegalArgumentException("Quantum book store: Not enough stock.");
                    }
                    pb.setStock(pb.getStock() - quantity);
                    pb.shipBook(address);
                    return pb.getPrice() * quantity;
                } else if (book instanceof EBook) {
                    System.out.println("Quantum book store: Sending eBook to " + email);
                    return book.getPrice() * quantity;
                }
            }
        }
        throw new IllegalArgumentException("Quantum book store: Book not found.");
    }
}