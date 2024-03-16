package Controller;

import View.IView;
import View.PanelView;

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

    public void
}
