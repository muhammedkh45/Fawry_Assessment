public class App {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        EBook ebook = new EBook("1234567890", "Digital Java", 2023, 29.99, "Alice Smith", "PDF");
        PaperBook paperBook = new PaperBook("0987654321", "Java Programming", 2022, 39.99, "Bob Johnson", 100, 1.5);
        ShowcaseBook showcaseBook = new ShowcaseBook("1122334455", "Rare Java", 2010, "Carol Lee");

        inventory.addBook(ebook);
        inventory.addBook(paperBook);
        inventory.addBook(showcaseBook);

        System.out.println("Quantum book store: Books in inventory:");
        for (Book book : inventory.getBooks()) {
            System.out.println("Quantum book store: " + book.getBookDetails());
        }
    }
}