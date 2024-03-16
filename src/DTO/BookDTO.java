package DTO;

import Model.Entity.Book;

public class BookDTO {

    private String title;
    private int edition;
    private String author;
    private Boolean available;
    private int timesBorrowed;

    public BookDTO(String title, int edition, String author) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.available = true;
        this.timesBorrowed = 0;
    }

    public BookDTO(Book domain){
        this.title = domain.getTitle();
        this.edition = domain.getEdition();
        this.author = domain.getAuthor();
        this.available = domain.isAvailable();
        this.timesBorrowed = domain.getTimesBorrowed();
    }

    public Book toDomain(){
        return new Book(title, edition, author, available, timesBorrowed);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }
}
