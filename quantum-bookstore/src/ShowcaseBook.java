public class ShowcaseBook extends Book {
    public ShowcaseBook(String ISBN, String title, int year, String author) {
        super(ISBN, title, year, 0.0, author);
    }

    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public String getBookDetails() {
        return super.getBookDetails() + " [Showcase Only]";
    }
}