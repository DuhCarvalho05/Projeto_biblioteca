package View;

import Controller.BookController;
import Controller.UserController;

public class Console {
    BookController bookController;
    UserController userController;

    public Console() {
        this.bookController = new BookController();
        this.userController = new UserController();
    }
}
