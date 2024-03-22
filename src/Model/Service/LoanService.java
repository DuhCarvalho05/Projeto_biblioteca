package Model.Service;

import Model.Dao.BookDaoImpl;
import Model.Dao.LoanDao;
import Model.Dao.LoanDaoImpl;
import Model.Dao.UserDaoImpl;
import Model.Entity.Book;
import Model.Entity.Loan;
import Model.Entity.User;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class LoanService {
    private final LoanDao loanDao;
    private final BookDaoImpl bookDao;
    private final UserDaoImpl userDao;

    public LoanService() {
        this.loanDao = LoanDaoImpl.getInstance();
        this.bookDao = BookDaoImpl.getInstance();
        this.userDao = UserDaoImpl.getInstance();
    }

    public Boolean insert(Loan loan){;
        return loanDao.insert(loan) && bookDao.update(loan.getBook());
    }
    public Boolean delete(Loan loan){
        return loanDao.delete(loan);
    }
    public List<Loan> getAll(){
        return loanDao.getAll();
    }

    public List<Loan> getByBook(Book book) {
        ArrayList <Loan> loans = new ArrayList<>();

        for (Loan l : loanDao.getAll()){
            if (l.getBook().equals(book)){
                loans.add(l);
            }
        }
        return loans;
    }

    public List<User> getByUser(User user) {
        ArrayList <User> users = new ArrayList<>();
        for (User u : userDao.getAll()){
            if (u.getEmail().equals(user.getEmail())){
                users.add(u);
            }
        }
        return users;
    }

    public List<Loan> getByReturnDate(LocalDate date) {
        ArrayList <Loan> loans = new ArrayList<>();
        for (Loan l : loanDao.getAll()){
            if (l.getReturnDate().isEqual(date)){
                loans.add(l);
            }
        }
        return loans;
    }

    public List<Loan> getByAcquiredDate(LocalDate date) {
        ArrayList <Loan> loans = new ArrayList<>();
        for (Loan l : loanDao.getAll()){
            if (l.getAcquiredDate().isEqual(date)){
                loans.add(l);
            }
        }
        return loans;
    }

    private List<Loan> getLateLoans() {
        ArrayList <Loan> loans = new ArrayList<>();
        for (Loan l : loanDao.getAll()){
            if (l.isDelayed()){
                loans.add(l);
            }
        }
        return loans;
    }

    public List<Book> getLateBooks() {
        ArrayList <Book> lateBooks = new ArrayList<>();
        for(Loan l : getLateLoans()){
            lateBooks.add(l.getBook());
        }
        return lateBooks;
    }
}
