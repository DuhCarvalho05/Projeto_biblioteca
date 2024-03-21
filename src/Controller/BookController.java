package Controller;

import DTO.BookDTO;
import Model.Entity.Book;
import Model.Service.BookService;
import View.IView;
import View.PanelView;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    BookService service;
    IView view;

    public BookController(IView view) {
        service = new BookService();
        this.view = view;
    }

    public void createBook(){
        var book = view.readBook();
        view.alertScreen(service.insert(book.toDomain()));
    }

    public void getAll(){
        List<Book> books = service.getAll();
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            booksDTO.add(new BookDTO(book));
        }
        view.showAllBooks(booksDTO);
    }
}
