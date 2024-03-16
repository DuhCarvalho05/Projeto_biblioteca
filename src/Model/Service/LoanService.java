package Model.Service;

import Model.Dao.LoanDao;
import Model.Dao.LoanDaoImpl;
import Model.Entity.Book;
import Model.Entity.Loan;
import Model.Entity.User;

import java.util.List;

public class LoanService {
    private LoanDao dao;

    public LoanService() {
        this.dao = LoanDaoImpl.getInstance();
    }

    public Boolean insert(Loan loan){
       return dao.insert(loan);
    }
    public Boolean delete(Loan loan){
        return dao.delete(loan);
    }
    public List<Loan> getAll(){
        return dao.getAll();
    }
    public Loan getByBook(Book book){
        return dao.getByBook(book);
    }
    public Loan getByUser(User user){
        return dao.getByUser(user);
    }



}
