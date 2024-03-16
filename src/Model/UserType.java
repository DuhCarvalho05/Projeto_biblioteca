package Model;

public enum UserType {
    EMPLOYEE(1),
    STUDENT(2);

    private final int value;
    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public UserType userType(int value) {
        return UserType.values()[value];
    }
}
