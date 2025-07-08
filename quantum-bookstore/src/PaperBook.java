public class PaperBook extends Book {
    private int stock;
    private double weight;

    public PaperBook(String ISBN, String title, int year, double price, String author, int stock, double weight) {
        super(ISBN, title, year, price, author);
        this.stock = stock;
        this.weight = weight;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void shipBook(String address) {
        System.out.println("Quantum book store: Shipping book '" + title + "' to " + address);
    }

    @Override
    public String getBookDetails() {
        return super.getBookDetails() + ", Stock: " + stock + ", Weight: " + weight;
    }
}