package View.Enum;

public enum MenuOptions {

    INSERT_BOOK("Adicionar livro"),
    INSERT_USER("Adicionar usuário"),
    RESERVE_BOOK("Reservar livro"),
    RETURN_BOOK("Devolver livro"),
    LOGS("Relatórios"),
    QUIT("Sair");

    private final String value;

    MenuOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
