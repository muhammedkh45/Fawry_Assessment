public abstract class Book {
    protected String ISBN;
    protected String title;
    protected int year;
    protected double price;
    protected String author;

    public Book(String ISBN, String title, int year, double price, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookDetails() {
        return "ISBN: " + ISBN + ", Title: " + title + ", Year: " + year + ", Price: " + price + ", Author: " + author;
    }

    public boolean isForSale() {
        return true;
    }
}