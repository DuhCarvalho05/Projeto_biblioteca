package Model.Dao;

import Exceptions.ReturnFailedException;
import Model.Entity.Book;

import java.util.*;

public class BookDaoImpl implements BookDao{
    private static BookDaoImpl instance;
    private final Collection<Book> dataset;

    public BookDaoImpl(){
        dataset = new TreeSet<>();
    }

    public static BookDaoImpl getInstance(){
        if(instance == null)
            instance = new BookDaoImpl();

        return instance;
    }

    @Override
    public Boolean insert(Book book) {
        if (book != null)
            return dataset.add(new Book(book.getTitle(), book.getEdition(),
                    book.getAuthor(), book.isAvailable(), book.getTimesBorrowed()));

        return false;
    }

    @Override
    public Boolean update(Book book) {
        if (book != null){
            if (dataset.remove(book)) {
                //TO DO - Setar availability ao devolver.
                return dataset.add(new Book(book.getTitle(), book.getEdition(),
                        book.getAuthor(), book.isAvailable(), book.getTimesBorrowed()));
            }
        }
        return false;
    }

    @Override
    public Boolean delete(Book book) {
        if (book != null)
            return dataset.remove(book);

        return false;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public Book getById(String title, int edition) throws ReturnFailedException {
         for (Book b : dataset){
             if ((b.getEdition() == edition) && b.getTitle().equals(title))
                 return new Book(b.getTitle(), b.getEdition(), b.getAuthor(), b.isAvailable(), b.getTimesBorrowed());

         }
        throw new ReturnFailedException("Não foi possível encontrar o livro.");
    }
}