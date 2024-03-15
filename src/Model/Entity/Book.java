package Model.Entity;

public class Book {
    private String title;
    private int edition;
    private String author;
    private boolean isAvailable;

    private int timesBorrowed;

    public Book(String title, int edition, String author,Boolean isAvailable, int timesBorrowed) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.isAvailable = true;
        this.timesBorrowed = timesBorrowed;

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

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    public boolean setAvailability(boolean availability) {
        if (isAvailable == availability)
            return false;
        else
            isAvailable = availability;

        return true;
    }
}
