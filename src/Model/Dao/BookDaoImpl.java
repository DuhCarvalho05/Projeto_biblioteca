package Model.Dao;

import Model.Entity.Book;

import java.util.*;

public class BookDaoImpl implements BookDao{
    private static BookDaoImpl instance;
    private final Collection<Book> dataset;

    public BookDaoImpl(){
        dataset = new TreeSet<>();
    }

    public static BookDaoImpl getInstance(){
        if(instance == null){
            instance = new BookDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(Book book) {
        if (book != null){
            return dataset.add(new Book(book.getTitle(), book.getEdition(),
                    book.getAuthor(), book.isAvailable(), book.getTimesBorrowed()));
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        if (book != null){
            if (dataset.remove(book))
                book.setBorrow();
            return dataset.add(new Book(book.getTitle(), book.getEdition(),
                    book.getAuthor(), book.isAvailable(), book.getTimesBorrowed()));
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        if (book != null){
            return dataset.remove(book);
        }
        return false;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public Book getById(String title, int edition) {
         for (Book b : dataset){
             if ((b.getEdition() == edition) && b.getTitle().equals(title)){
                 return new Book(b.getTitle(), b.getEdition(), b.getAuthor(), b.isAvailable(), b.getTimesBorrowed());
             }
         }
        return null;
    }
}
