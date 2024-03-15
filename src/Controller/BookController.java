package Controller;

public class BookController {

    BookService service;
    ViewConsole view;

    public BookController() {
        service = new BookService();
        view = new ViewConsole();
    }

    public void createBook(){

        var book = view.createBook();

        if(service.create(book.toDomain())){
            view.succes();
        }else{
            view.fail();
        }
    }

    public void
}
