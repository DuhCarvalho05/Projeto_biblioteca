package Model.Service;

import Model.Dao.BookDao;
import Model.Dao.BookDaoImpl;
import Model.Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookDao dao;

    public BookService (){
        this.dao = BookDaoImpl.getInstance();
    }

    public Boolean insert(Book book){
        return dao.insert(book);
    }
    public Boolean delete(Book book){
        return dao.delete(book);
    }

    public List<Book> getAll(){
        return dao.getAll();
    }
    public Book getById(String title, int edition){
        return dao.getById(title,edition);
    }
    public List<Book> getBorrowedBooks(){
        List<Book> l = new ArrayList<>();
        for (Book b: getAll()){
            if (!b.isAvailable()){
                l.add(b);
            }
        }
        return l;
    }

}
