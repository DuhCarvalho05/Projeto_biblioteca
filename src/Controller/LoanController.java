package Controller;

import DTO.BookDTO;
import DTO.LoanDTO;
import DTO.UserDTO;
import Model.Entity.Book;
import Model.Service.BookService;
import Model.Service.LoanService;
import Model.Service.UserService;
import View.IView;
import View.PanelView;

import java.util.ArrayList;
import java.util.List;

public class LoanController {
    LoanService loanService;
    BookService bookService;
    UserService userService;
    IView view;

    public LoanController(IView view) {
        this.loanService = new LoanService();
        this.bookService = new BookService();
        this.userService = new UserService();
        this.view = view;
    }

    public void createLoan() {
        var booksDTO = BookDTO.toDomain(bookService.getAll());
        var usersDTO = UserDTO.toDomain(userService.getAll());
        var loan = view.readLoan(booksDTO, usersDTO);

        if(loan == null) {
            view.showMessage("Operação cancelada", "Operação cancelada");
        } else {
            view.alertScreen(loanService.insert(loan.toDomain()));
        }
    }

    public void getAll() {
        var booksDTO = BookDTO.toDomain(bookService.getAll());
        view.showLoanBooks(booksDTO);
    }

    public void getAllUsers() {
        var loanDTO = LoanDTO.toDomain(loanService.getAll());
        view.showUserWithBook(loanDTO);
    }

    public void getAllPenalizedUsers() {
        var usersDTO = UserDTO.toDomain(userService.getAll());
    }
}
