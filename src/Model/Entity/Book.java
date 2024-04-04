package Model.Entity;

public class Book implements Comparable<Book> {
    private final String title;
    private final int edition;
    private final String author;
    private boolean isAvailable;
    private int timesBorrowed;

    public Book(String title, int edition, String author, boolean isAvailable, int timesBorrowed) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.isAvailable = isAvailable;
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

    public void setBorrow() {
        if (isAvailable()){
            timesBorrowed++;
            isAvailable = false;
        }
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return (edition == book.edition) && title.trim().equalsIgnoreCase(book.title.trim());
    }

    @Override
    public int compareTo(Book book){
        int result =
                this.getTitle().replace(" ", "").toUpperCase().compareTo(book.getTitle().replace(" ", "").toUpperCase());
        return result == 0 ? this.getEdition() - (book.getEdition()) : result;
    }
}
