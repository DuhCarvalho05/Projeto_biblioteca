package Model.Dao;

import Model.Entity.*;

import java.util.List;

public interface LoanDao {
    boolean insert(Loan loan);
    boolean delete(Loan loan);
    List<Loan> getAll();
    List<Loan> getByBook(Book book);
    List<Loan> getByUser(User user);
}
