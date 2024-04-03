package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
import Model.Entity.Book;

import java.util.List;

public interface BookDao {
    boolean insert(Book book) throws InsertFailedException;
    boolean update(Book book) throws FailedReturnException;;
    boolean delete(Book book) throws DeleteFailedException;
    List<Book> getAll();
    Book getById(String title, int edition) throws FailedReturnException;
}
