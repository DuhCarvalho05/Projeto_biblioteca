package View;

import java.util.List;
import DTO.*;
import View.Enum.*;

public interface IView {

    MenuOptions showMenu();

    MenuLogs showMenuLogs();

    UserDTO readUser();

    BookDTO readBook();

    LoanDTO readLoan(List<BookDTO> books, List<UserDTO> users);

    LoanDTO returnBook(List<LoanDTO> loanBooks);

    void showAllBooks(List<BookDTO> books);

    void showLoanBooks(List<BookDTO> books);

    void showUserWithBook(List<LoanDTO> reserveds);

    void showUserWithPenality(List<UserDTO> penalizeds);

    void showLateBooking(List<LoanDTO> lateBooking);

    void alertScreen(boolean success);

    void showMessage(String message, String title);
}
