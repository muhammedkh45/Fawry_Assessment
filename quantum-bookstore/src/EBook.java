public class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, int year, double price, String authorName, String fileType) {
        super(ISBN, title, year, price, authorName);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void sendViaEmail(String email) {
        System.out.println("Sending " + title + " to " + email + " as a " + fileType + " file.");
    }

    @Override
    public String getBookDetails() {
        return super.getBookDetails() + ", File Type: " + fileType;
    }
}