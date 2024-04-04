package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.ReturnFailedException;
import Exceptions.InsertFailedException;
import Model.Entity.Book;

import java.util.List;

public interface BookDao {
    Boolean insert(Book book) throws InsertFailedException;
    Boolean update(Book book) throws ReturnFailedException;;
    Boolean delete(Book book) throws DeleteFailedException;
    List<Book> getAll();
    Book getById(String title, int edition) throws ReturnFailedException;
}
