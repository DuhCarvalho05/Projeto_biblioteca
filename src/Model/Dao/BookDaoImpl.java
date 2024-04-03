package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
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
    public boolean insert(Book book) throws InsertFailedException {
        if (book != null){
            return dataset.add(book);
        }
        throw new InsertFailedException("Não foi possível inserir o livro.");
    }

    @Override
    public boolean update(Book book) throws FailedReturnException {
        if (book != null){
            if (dataset.remove(book))
                book.setBorrow();
            return dataset.add(book);
        }
        throw new FailedReturnException("Não foi possível atualizar o livro.");
    }

    @Override
    public boolean delete(Book book) throws DeleteFailedException {
        if (book != null){
            return dataset.remove(book);
        }
        throw new DeleteFailedException("Não foi possível deletar esse livro.");
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public Book getById(String title, int edition) throws FailedReturnException {
         for (Book b : dataset){
             if ((b.getEdition() == edition) && b.getTitle().equals(title)){
                 return b;
             }
         }
        throw new FailedReturnException("Livro não encontrado.");
    }
}
