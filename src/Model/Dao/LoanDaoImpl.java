package Model.Dao;

import Model.Entity.Book;
import Model.Entity.Loan;
import Model.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LoanDaoImpl implements LoanDao{
    private static LoanDaoImpl instance;
    private static Set<Loan> dataset;

    public LoanDaoImpl(){
        dataset = new TreeSet<>();
    }

    public static LoanDaoImpl getInstance(){
        if(instance == null){
            instance = new LoanDaoImpl();
        }
        return instance;
    }

    public boolean insert(Loan loan) {
        return dataset.add(loan);
    }

    @Override
    public boolean delete(Loan loan) {
        //TODO
        return false;
    }

    @Override
    public List<Loan> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public Loan getByBook(Book book) {
        //TODO
        return null;
    }

    @Override
    public Loan getByUser(User user) {
        return null;
    }
}
