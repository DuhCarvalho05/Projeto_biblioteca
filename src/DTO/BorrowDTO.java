package DTO;

import java.time.LocalDate;

public class BorrowDTO {

    private UserDTO userDTO;
    private BookDTO bookDTO;
    private LocalDate takenDay;
    private LocalDate deliveryDay;
    private Boolean late;

    public BorrowDTO(UserDTO userDTO, BookDTO bookDTO, LocalDate takenDay, LocalDate deliveryDay, Boolean late) {
        this.userDTO = userDTO;
        this.bookDTO = bookDTO;
        this.takenDay = takenDay;
        this.deliveryDay = deliveryDay;
        this.late = late;
    }

    // Fazer o ToDOmain() do empréstimo faz sentido?

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public LocalDate getTakenDay() {
        return takenDay;
    }

    public void setTakenDay(LocalDate takenDay) {
        this.takenDay = takenDay;
    }

    public LocalDate getDeliveryDay() {
        return deliveryDay;
    }

    public void setDeliveryDay(LocalDate deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public Boolean getLate() {
        return late;
    }

    public void setLate(Boolean late) {
        this.late = late;
    }
}
