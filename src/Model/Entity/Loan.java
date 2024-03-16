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
        return this.equals(loan) && this.bailee.equals(loan.bailee) &&
                this.borrowed.equals(loan.borrowed) &&
                this.acquiredDate.getDayOfYear() == loan.acquiredDate.getDayOfYear() &&
                this.returnDate.getDayOfYear() == loan.returnDate.getDayOfYear();
    }

    @Override
    public int compareTo(Loan loan){
        if (loan != null) {
            return this.equals(loan) ? 0 :
                    this.returnDate.getDayOfYear() - loan.returnDate.getDayOfYear();
        }
        return 0;
    }
}