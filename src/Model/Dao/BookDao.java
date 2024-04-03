package Model.Dao;

import Exceptions.FailedReturnExecption;
import Model.Entity.Book;

import java.util.List;

public interface BookDao {
    boolean insert(Book book) throws FailedReturnExecption;
    boolean update(Book book) throws FailedReturnExecption;;
    boolean delete(Book book) throws FailedReturnExecption;
    List<Book> getAll();
    Book getById(String title, int edition) throws FailedReturnExecption;
}
