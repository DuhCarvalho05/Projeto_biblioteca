package Model.Entity;

import java.time.LocalDate;

public class Loan {
    private final User bailee;
    private final Book borrowed;
    private final LocalDate acquiredDate;
    private final LocalDate returnDate;

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
}