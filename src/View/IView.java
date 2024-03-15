package View;

import java.util.List;

public interface IView {

    MenuOptions showMenu();

    UserDto readUser();

    BookDto readBook();

    ReserveDto readReserve(List<BookDto> books, List<UserDto> users);

    void showAllBooks(List<BookDto> books);

    void showReservedBooks(List<BookDto> books);

    void showUserWithBook(List<ReserveDto> reserveds);

    void showUserWithPenality(List<UserDto> penalizeds);

    void showLateBooking(List<ReserveDto> late);
}
