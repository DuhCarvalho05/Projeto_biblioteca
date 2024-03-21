package DTO;

import Model.Entity.Book;
import Model.Entity.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDTO {
    private UserDTO user;
    private BookDTO book;
    private LocalDate acquiredDate;
    private LocalDate returnDate;
    private Boolean late;

    public LoanDTO(UserDTO user, BookDTO book, LocalDate acquiredDate, LocalDate returnDate, Boolean late) {
        this.user = user;
        this.book = book;
        this.acquiredDate = acquiredDate;
        this.returnDate = returnDate;
        this.late = late;
    }

    public LoanDTO(UserDTO user, BookDTO book){
        this.user = user;
        this.book = book;
        acquiredDate = LocalDate.now();
        returnDate = acquiredDate.plusDays(14);
        late = false;
    }

    public Loan toDomain() {
        return  new Loan(user.toDomain(), book.toDomain(), acquiredDate, returnDate);
    }

    public static List<LoanDTO> toDomain(List<Loan> loans) {
        List<LoanDTO> loansDTO = new ArrayList<>();
        for (Loan loan : loans) {
            loansDTO.add(new LoanDTO(new UserDTO(loan.getBailee()), new BookDTO(loan.getBook()), loan.getAcquiredDate(), loan.getReturnDate(), loan.isDelayed()));
        }

        return loansDTO;
    }
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getLate() {
        return late;
    }

    public void setLate(Boolean late) {
        this.late = late;
    }
}
