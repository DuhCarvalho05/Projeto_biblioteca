package View;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DTO.*;
import View.Enum.*;

import javax.swing.*;

public class PanelView implements IView{
    @Override
    public MenuOptions showMenu() {
        String option;
        Panel panel = new Panel();

        panel.setLayout(new GridLayout(1,1));

        JComboBox<String> comboBox = new JComboBox<>();
        for (MenuOptions menuOption : MenuOptions.values())
            comboBox.addItem(menuOption.getValue());

        comboBox.addItem("AAAA");

        panel.add(comboBox);

        JOptionPane.showMessageDialog(null, panel, "Menu", JOptionPane.QUESTION_MESSAGE);
        option = (String) comboBox.getSelectedItem();

        for (MenuOptions menuOption : MenuOptions.values()) {
            if (menuOption.getValue().equals(option)){
                return menuOption;
            }
        }

        throw new IllegalArgumentException("Invalid value: " + option);
    }

    @Override
    public MenuLogs showMenuLogs() {
        Object option;
        String[] options = {"Todos os livros", "Livros emprestados", "Usuários com livros", "Usuários penalizados", "Usuários atrasados", "Voltar"};
        option = JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(option)){
                return MenuLogs.values()[i];
            }
        }

        return null;
    }

    @Override
    public UserDTO readUser() {
        Panel panel = new Panel();

        panel.setLayout(new GridLayout(4,1));

        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();

        panel.add(new Label("Nome:"));
        panel.add(name);
        panel.add(new Label("Email:"));
        panel.add(email);
        panel.add(new Label("Telefone:"));
        panel.add(phone);
        panel.add(new Label("Tipo de usuário:"));

        JList<String> userType = new JList<>(new String[]{"Aluno", "Professor"});

        panel.add(userType);

        int option = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Usuário", JOptionPane.OK_CANCEL_OPTION);

        if(option == JOptionPane.OK_OPTION){
            return new UserDTO(name.getText(), email.getText(), phone.getText(), userType.getSelectedValue());
        }

        return null;
    }

    @Override
    public BookDTO readBook() {
        Panel panel = new Panel();

        panel.setLayout(new GridLayout(4,1));

        JTextField title = new JTextField();
        JTextField edition = new JTextField();
        JTextField author = new JTextField();

        panel.add(new Label("Titulo do livro:"));
        panel.add(title);
        panel.add(new Label("Edição:"));
        panel.add(edition);
        panel.add(new Label("Autor:"));
        panel.add(author);

        int option = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Livro", JOptionPane.OK_CANCEL_OPTION);

        if(option == JOptionPane.OK_OPTION){
            return new BookDTO(title.getText(), Integer.parseInt(edition.getText()), author.getText());
        }

        return null;
    }

    @Override
    public LoanDTO readLoan(List<BookDTO> books, List<UserDTO> users) {
        List<String> userNames = new ArrayList<>();
        List<String> bookTitles = new ArrayList<>();

        for (UserDTO user : users) {
            userNames.add(user.getName());
        }

        for (BookDTO book : books) {
            //Show title and edition
            bookTitles.add(book.getTitle() + " | Edição: " + book.getEdition());
        }

        JList<String> userJList = new JList<>(userNames.toArray(new String[0]));
        JList<String> bookJList = new JList<>(bookTitles.toArray(new String[0]));

        userJList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bookJList.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Make user list more pretty
        userJList.setLayoutOrientation(JList.VERTICAL);
        userJList.setVisibleRowCount(-1);

        //Make book list more pretty
        bookJList.setLayoutOrientation(JList.VERTICAL);
        bookJList.setVisibleRowCount(-1);

        Panel panel = new Panel();

        panel.setLayout(new GridLayout(3,1));
        panel.add(new Label("Selecione o usuário:"));
        panel.add(userJList);
        panel.add(new Label(""));
        panel.add(new Label(""));
        panel.add(new Label("Selecione o livro:"));
        panel.add(bookJList);

        JOptionPane.showConfirmDialog(null, panel, "Emprestimo de livro", JOptionPane.OK_CANCEL_OPTION);

        UserDTO user = users.get(userJList.getSelectedIndex());
        BookDTO book = books.get(bookJList.getSelectedIndex());

        return new LoanDTO(user, book);
    }

    public LoanDTO returnBook(List<LoanDTO> loanBooks){
        List<String> loandedBooks = new ArrayList<>();

        for (LoanDTO loan : loanBooks) {
            loandedBooks.add(loan.getUser().getName() + "\n" + loan.getBook().getTitle() + " | Edição: " + loan.getBook().getEdition());
        }

        JList<String> loandedList = new JList<>(loandedBooks.toArray(new String[0]));

        loandedList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loandedList.setLayoutOrientation(JList.VERTICAL);
        loandedList.setVisibleRowCount(-1);

        Panel panel = new Panel();

        panel.setLayout(new GridLayout(3,1));
        panel.add(new Label("Selecione o usuário que está devolvendo o livro:"));
        panel.add(loandedList);

        JOptionPane.showConfirmDialog(null, panel, "Devolução de livro", JOptionPane.OK_CANCEL_OPTION);

        return loanBooks.get(loandedList.getSelectedIndex());
    }


    @Override
    public void showAllBooks(List<BookDTO> books) {
        String title = "Todos os livros";
        booksPainelBuilder(books, title);
    }

    @Override
    public void showLoanBooks(List<BookDTO> books) {
        String title = "Livros emprestados";
        booksPainelBuilder(books, title);
    }

    @Override
    public void showUserWithBook(List<LoanDTO> reserveds) {
        String title = "Livros emprestados";
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sb.append("------------------------------------------------------------------------\n");
        for (LoanDTO reserved : reserveds){

            BookDTO book = reserved.getBook();
            UserDTO user = reserved.getUser();

            sb.append("Nome: ").append(user.getName()).append("\n");
            sb.append("Titulo do livro: ").append(book.getTitle()).append("\n");
            sb.append("Edição: ").append(book.getEdition()).append("\n");
            sb.append("Data do emprestimo: ").append(reserved.getAcquiredDate().format(formatter)).append("\n");
            sb.append("Data de devolução: ").append(reserved.getReturnDate().format(formatter)).append("\n");
            sb.append("------------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, panelBuilder(sb), title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showUserWithPenality(List<UserDTO> penalizeds) {
        String title = "Usuários sendo penalizados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (UserDTO user : penalizeds){
            sb.append("Nome: ").append(user.getName()).append("\n");
            sb.append("E-mail: ").append(user.getEmail()).append("\n");
            sb.append("Telefone: ").append(user.getPhone()).append("\n");
            sb.append("Tipo de usuário: ").append(user.getUserType()).append("\n");
            sb.append("Dias de penalidade restantes: ").append(user.getPenalty()).append("\n");
            sb.append("------------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, panelBuilder(sb), title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showLateBooking(List<LoanDTO> lateBooking) {
        String title = "Usuários atrasados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (LoanDTO late: lateBooking){
            BookDTO book = late.getBook();
            UserDTO user = late.getUser();

            sb.append("Titulo: ").append(book.getTitle()).append("\n");
            sb.append("Edição: ").append(book.getEdition()).append("\n");
            sb.append("\n");
            sb.append("Nome: ").append(user.getName()).append("\n");
            sb.append("E-mail: ").append(user.getEmail()).append("\n");
            sb.append("\n");

            sb.append("Dias atrasados: ").append("\n");
            sb.append("Dias até penalidade: ").append("\n");
            sb.append("Dias de penalidade acumulados: ").append("\n");

            sb.append("------------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, panelBuilder(sb), title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void alertScreen(boolean success){

        String title;
        String menssage;
        int messageType;

        if (success){
            title = "Sucesso";
            menssage = "Operação realizada com sucesso!";
            messageType = JOptionPane.PLAIN_MESSAGE;
        } else {
            title = "Erro";
            menssage = "Erro na ao realizar a operação!";
            messageType = JOptionPane.ERROR_MESSAGE;
        }

        JOptionPane.showMessageDialog(null, menssage, title, messageType);
    }

    @Override
    public void showMessage(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static Panel panelBuilder(StringBuilder sb){
        JTextArea textArea = new JTextArea(sb.toString());

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        Panel panel = new Panel();
        panel.add(scrollPane);

        return panel;
    }

    private static void booksPainelBuilder(List<BookDTO> books, String title) {
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (BookDTO book : books){
            sb.append("Titulo: ").append(book.getTitle()).append("\n");
            sb.append("Edição: ").append(book.getEdition()).append("\n");
            sb.append("Autor: ").append(book.getAuthor()).append("\n");
            sb.append("Está disponível: ").append(book.isAvailable() ? "Sim" : "Não").append("\n");
            sb.append("Vezes emprestado: ").append(book.getTimesBorrowed()).append("\n");
            sb.append("------------------------------------------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, panelBuilder(sb), title, JOptionPane.PLAIN_MESSAGE);
    }
}
