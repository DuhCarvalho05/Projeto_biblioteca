package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
import Model.Entity.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class LoanDaoImpl implements LoanDao{
    private static LoanDaoImpl instance;
    private final Collection<Loan> dataset;

    public LoanDaoImpl(){
         dataset = new TreeSet<>();
    }

    public static LoanDaoImpl getInstance(){
        if(instance == null){
            instance = new LoanDaoImpl();
        }
        return instance;
    }

    public boolean insert(Loan loan) throws InsertFailedException {
        if (loan != null) {
            return dataset.add(loan);
        }
        throw new InsertFailedException("Não foi possível inserir empréstimo");
    }

    @Override
    public boolean delete(Loan loan) throws DeleteFailedException {
        if (loan != null){
            return dataset.remove(loan);
        }
       throw new DeleteFailedException("Não foi possível detelar empréstimo");
    }

    @Override
    public List<Loan> getAll() {
        return new ArrayList<>(dataset);
    }
}
