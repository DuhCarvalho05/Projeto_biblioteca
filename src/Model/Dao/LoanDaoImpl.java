package Model.Dao;

import Model.Entity.Book;
import Model.Entity.Loan;
import Model.Entity.User;

import java.util.List;

public class LoanDaoImpl implements LoanDao{
    private static LoanDaoImpl instance;
    private static List<Loan> dataset;

    public LoanDaoImpl(){
        //TODO
    }

    public static LoanDaoImpl getInstance(){
        if(instance == null){
            instance = new LoanDaoImpl();
        }
        return instance;
    }

    public boolean insert(Loan loan) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Loan loan) {
        //TODO
        return false;
    }

    @Override
    public List<Loan> getAll() {
        //TODO
        return null;
    }

    @Override
    public List<Loan> getByBook(Book book) {
        //TODO
        return null;
    }

    @Override
    public List<Loan> getByUser(User user) {
        return null;
    }
}
