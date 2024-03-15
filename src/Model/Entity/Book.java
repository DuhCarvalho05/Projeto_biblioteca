package Model.Entity;

public class Book {
    private final String title;
    private final int edition;
    private final String author;
    private boolean isAvailable;
    private int timesBorrowed;

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

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public boolean setBorrow() {
        if (!isAvailable())
            return false;

        timesBorrowed++;
        return true;
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

        isAvailable = availability;
        return true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
