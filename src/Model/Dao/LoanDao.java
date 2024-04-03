package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
import Model.Entity.*;

import java.util.List;

public interface LoanDao {
    boolean insert(Loan loan) throws InsertFailedException;
    boolean delete(Loan loan) throws DeleteFailedException;;
    List<Loan> getAll();
}
