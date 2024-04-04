package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.InsertFailedException;
import Model.Entity.*;

import java.util.List;

public interface LoanDao {
    Boolean insert(Loan loan) throws InsertFailedException;
    Boolean delete(Loan loan) throws DeleteFailedException;
    List<Loan> getAll();
}
