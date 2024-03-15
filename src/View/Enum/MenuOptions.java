package View.Enum;

public enum MenuOptions {

    INSERT_BOOK(0),
    INSERT_USER(1),
    RESERVE_BOOK(2),
    LOGS(3),
    QUIT(4);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }
}
