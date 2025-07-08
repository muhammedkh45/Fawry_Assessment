public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        PaperBook pb = new PaperBook("111", "Java Basics", 2015, 50.0, "John Doe", 10, 1.2);
        EBook eb = new EBook("222", "Advanced Java", 2020, 30.0, "Jane Roe", "EPUB");
        ShowcaseBook sb = new ShowcaseBook("333", "Java Demo", 2018, "Demo Author");
        inventory.addBook(pb);
        inventory.addBook(eb);
        inventory.addBook(sb);

        try {
            double paid = inventory.buyBook("111", 2, "buyer@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount for PaperBook: " + paid);
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        try {
            double paid = inventory.buyBook("222", 1, "buyer@email.com", "N/A");
            System.out.println("Quantum book store: Paid amount for EBook: " + paid);
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        try {
            inventory.buyBook("333", 1, "buyer@email.com", "N/A");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

        System.out.println("Quantum book store: Removing outdated books...");
        for (Book removed : inventory.removeOutdatedBooks(7)) {
            System.out.println("Quantum book store: Removed " + removed.getBookDetails());
        }

        System.out.println("Quantum book store: Final inventory:");
        for (Book book : inventory.getBooks()) {
            System.out.println("Quantum book store: " + book.getBookDetails());
        }
    }
}