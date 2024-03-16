package Model.Entity;

public class Book implements Comparable<Book> {
    private final String title;
    private final int edition;
    private final String author;
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

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public boolean setBorrow() {
        if (!isAvailable())
            return false;

        timesBorrowed++;
        return true;
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return edition == book.edition && title.equals(book.title);
    }

    @Override
    public int compareTo(Book book){
        if (book != null) {
            return (this.title + this.edition).compareTo(book.title + book.edition);
        }
        return 0;
    }
}
