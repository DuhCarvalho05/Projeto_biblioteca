package View;

import java.util.List;

public class PanelView implements IView{
    @Override
    public MenuOptions showMenu() {
        return null;
    }

    @Override
    public UserDto readUser() {
        return null;
    }

    @Override
    public BookDto readBook() {
        return null;
    }

    @Override
    public ReserveDto readReserve(List<BookDto> books, List<UserDto> users) {
        return null;
    }

    @Override
    public void showAllBooks(List<BookDto> books) {

    }

    @Override
    public void showReservedBooks(List<BookDto> books) {

    }

    @Override
    public void showUserWithBook(List<ReserveDto> reserveds) {

    }

    @Override
    public void showUserWithPenality(List<UserDto> penalizeds) {

    }

    @Override
    public void showLateBooking(List<ReserveDto> late) {

    }
}
