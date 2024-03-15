package Model.Entity;

import java.time.LocalDate;

public class Loan {
    private User bailee;
    private Book borrowed;
    private LocalDate acquiredDate;
    private LocalDate returnDate;
    private int timesBorrowed;

    public Loan(User bailee, Book book, LocalDate acquiredDate,
                LocalDate returnDate) {
        this.bailee = bailee;
        this.borrowed = book;
        this.acquiredDate = acquiredDate;
        this.returnDate = returnDate;
    }

    public User getBailee() {
        return bailee;
    }

    public Book getBook() {
        return borrowed;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }
}