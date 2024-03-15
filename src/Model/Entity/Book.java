package Model.Entity;

public class Book {
    private String title;
    private int edition;
    private String author;
    private boolean isAvailable;

    public Book(String title, int edition, String author) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public int getEdition() {
        return edition;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean setAvailability(boolean availability) {
        if (isAvailable == availability)
            return false;
        else
            isAvailable = availability;

        return true;
    }
}
