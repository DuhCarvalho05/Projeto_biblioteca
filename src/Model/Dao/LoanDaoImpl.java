package Model.Dao;

import Exceptions.FailedReturnExecption;
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

    public boolean insert(Loan loan) throws FailedReturnExecption {
        if (loan != null) {
            return dataset.add(loan);
        }
        throw new FailedReturnExecption("Não foi possível inserir empréstimo");
    }

    @Override
    public boolean delete(Loan loan) throws FailedReturnExecption {
        if (loan != null){
            return dataset.remove(loan);
        }
       throw new FailedReturnExecption("Não foi possível detelar empréstimo");
    }

    @Override
    public List<Loan> getAll() {
        return new ArrayList<>(dataset);
    }
}
