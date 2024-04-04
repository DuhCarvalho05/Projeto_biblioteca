package Model.Dao;

import Model.Entity.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class LoanDaoImpl implements LoanDao {
    private static LoanDaoImpl instance;
    private final Collection<Loan> dataset;

    public LoanDaoImpl(){
         dataset = new TreeSet<>();
    }

    public static LoanDaoImpl getInstance() {
        if(instance == null)
            instance = new LoanDaoImpl();

        return instance;
    }

    public Boolean insert(Loan loan) {
        if (loan != null)
            return dataset.add(new Loan(loan.getBailee(), loan.getBook(), loan.getAcquiredDate(), loan.getReturnDate()));

        return false;
    }

    @Override
    public Boolean delete(Loan loan) {
        if (loan != null)
            return dataset.remove(loan);

       return false;
    }

    @Override
    public List<Loan> getAll() {
        return new ArrayList<>(dataset);
    }
}