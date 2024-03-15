package View.Enum;

public enum MenuLogs {

    ALL_BOOKS(0),
    RESERVED_BOOKS(1),
    USER_WITH_BOOK(2),
    USER_WITH_PENALITY(3),
    LATE_BOOKING(4);

    private final int value;

    MenuLogs(int value) {
        this.value = value;
    }
}
