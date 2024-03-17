package Model.Entity;

import java.time.LocalDate;

public class Loan implements Comparable<Loan>{
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return this.bailee.equals(loan.bailee) &&
                this.borrowed.equals(loan.borrowed) &&
                this.acquiredDate.getDayOfYear() == loan.acquiredDate.getDayOfYear() && this.acquiredDate.getYear() == loan.acquiredDate.getYear();
    }

    @Override
    public int compareTo(Loan loan){
        int yearDiff =
                this.getReturnDate().getYear() - (loan.getReturnDate().getYear());
        if (yearDiff == 0)
            return this.getReturnDate().getDayOfYear() - (loan.getReturnDate().getDayOfYear());

        return yearDiff;
    }
}