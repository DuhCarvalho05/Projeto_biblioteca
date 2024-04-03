package Model.Dao;

import Exceptions.FailedReturnExecption;
import Model.Entity.*;

import java.util.List;

public interface LoanDao {
    boolean insert(Loan loan) throws FailedReturnExecption;
    boolean delete(Loan loan) throws FailedReturnExecption;;
    List<Loan> getAll();
}
