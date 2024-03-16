package Controller;

import DTO.BookDTO;
import Model.Entity.Book;
import View.IView;
import View.PanelView;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    BookService service;
    IView view;

    public BookController() {
        service = new BookService();
        view = new PanelView();
    }

    public void createBook(){

        var book = view.readBook();

        if(service.create(book.toDomain())){
            view.succes();
        }else{
            view.fail();
        }
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
