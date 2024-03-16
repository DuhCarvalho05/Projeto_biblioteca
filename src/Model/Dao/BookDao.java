package Model.Dao;

import Model.Entity.Book;

import java.util.List;

public interface BookDao {
    boolean insert(Book book);
    boolean delete(Book book);
    List<Book> getAll();
    Book getById(String title, int edition);
}
