package Model.Service;

import Exceptions.DeleteFailedException;
import Exceptions.InvalidValuesException;
import Exceptions.ReturnFailedException;
import Exceptions.InsertFailedException;
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

    public boolean insert(Book book) throws InsertFailedException {
        if (book == null)
            throw new InsertFailedException("Livro inválido.");

        return dao.insert(book);
    }
    public boolean delete(Book book) throws DeleteFailedException {
        if (book == null)
            throw new DeleteFailedException("Livro inválido.");

        return dao.delete(book);
    }

    public List<Book> getAll() {
        return dao.getAll();
    }
    public Book getById(String title, int edition) throws InvalidValuesException, ReturnFailedException {
        if (title == null || edition == 0)
            throw new InvalidValuesException("Livro inexistente.");

        return dao.getById(title,edition);
    }

    public List<Book> getBorrowedBooks() {
        List<Book> l = new ArrayList<>();
        for (Book b: getAll()){
            if (!b.isAvailable()){
                l.add(b);
            }
        }
        return l;
    }

    public List<Book> getAvailableBooks() {
        List<Book> l = new ArrayList<>();
        for (Book b: getAll()){
            if (b.isAvailable()){
                l.add(b);
            }
        }
        return l;
    }
}