package View;

import java.util.List;
import DTO.*;
import View.Enum.MenuOptions;

public class PanelView implements IView{
    @Override
    public MenuOptions showMenu() {
        return null;
    }

    @Override
    public UserDTO readUser() {
        return null;
    }

    @Override
    public BookDTO readBook() {
        return null;
    }

    @Override
    public ReserveDto readReserve(List<BookDTO> books, List<UserDTO> users) {
        return null;
    }

    @Override
    public void showAllBooks(List<BookDTO> books) {

    }

    @Override
    public void showReservedBooks(List<BookDTO> books) {

    }

    @Override
    public void showUserWithBook(List<ReserveDto> reserveds) {

    }

    @Override
    public void showUserWithPenality(List<UserDTO> penalizeds) {

    }

    @Override
    public void showLateBooking(List<ReserveDto> late) {

    }
}
