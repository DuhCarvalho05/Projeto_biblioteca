package Model.Entity;

public class Loan {
    private User bailee;
    private Book borrowed;
    private String acquiredDate;
    private String returnDate;

    public Loan(User bailee, Book book, String acquiredDate, String returnDate) {
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

    public String getAcquiredDate() {
        return acquiredDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}