package Model.Enum;

public enum UserType {
    EMPLOYEE("Funcionário"),
    STUDENT("Estudante");

    private final String value;
    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public UserType userType(int value) {
        return UserType.values()[value];
    }
}
