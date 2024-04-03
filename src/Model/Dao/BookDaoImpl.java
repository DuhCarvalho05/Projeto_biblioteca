package Model.Dao;

import Exceptions.FailedReturnExecption;
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
    public boolean insert(Book book) throws FailedReturnExecption {
        if (book != null){
            return dataset.add(book);
        }
        throw new FailedReturnExecption("Não foi possível inserir o livro.");
    }

    @Override
    public boolean update(Book book) throws FailedReturnExecption {
        if (book != null){
            if (dataset.remove(book))
                book.setBorrow();
            return dataset.add(book);
        }
        throw new FailedReturnExecption("Não foi possível atualizar o livro.");
    }

    @Override
    public boolean delete(Book book) throws FailedReturnExecption {
        if (book != null){
            return dataset.remove(book);
        }
        throw new FailedReturnExecption("Não foi possível deletar esse livro.");
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public Book getById(String title, int edition) throws FailedReturnExecption {
         for (Book b : dataset){
             if ((b.getEdition() == edition) && b.getTitle().equals(title)){
                 return b;
             }
         }
        throw new FailedReturnExecption("Livro não encontrado.");
    }
}
