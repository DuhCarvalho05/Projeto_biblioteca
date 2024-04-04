package Model.Entity;

import Model.Enum.UserType;

import java.time.LocalDate;

public class Loan implements Comparable<Loan>{
    private final User bailee;
    private final Book borrowed;
    private final LocalDate acquiredDate;
    private final LocalDate returnDate;

    public Loan(User user, Book book, LocalDate acquiredDate,
                LocalDate returnDate) {

        borrowed = new Book(book.getTitle(), book.getEdition(), book.getAuthor(), book.isAvailable(), book.getTimesBorrowed());

        if (user.getUserType().equals(UserType.EMPLOYEE)) {
            bailee = new Employee(user.getName(), user.getEmail(), user.getPhone());
        } else {
            bailee = new Student(user.getName(), user.getEmail(), user.getPhone());
        }

        this.acquiredDate = acquiredDate;
        this.returnDate = returnDate;
        borrowed.setBorrow();
        book.setBorrow();
    }

    public Boolean isDelayed(){
        return getReturnDate().isBefore(LocalDate.now());
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
        if (this.equals(loan)) return 0;
        if (this.borrowed.equals(loan.borrowed)){
            return this.acquiredDate.compareTo(loan.acquiredDate);
        }
        return this.borrowed.compareTo(loan.borrowed);
    }
}