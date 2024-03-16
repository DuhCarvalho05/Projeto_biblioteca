package View;

import java.awt.*;
import java.util.List;
import DTO.*;
import View.Enum.MenuOptions;

import javax.swing.*;

public class PanelView implements IView{
    @Override
    public MenuOptions showMenu() {
        int option;
        String[] options = {"Cadastrar livro", "Cadastrar usuário", "Empréstimo de livor", "Relatórios", "Sair"};
        option = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "Sair");
        return MenuOptions.values()[option];
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

        //I dont know if this will work, but I think it will. This is for limit the user to choose between "Aluno" and "Funcionário".
        //We need to test this.
        JComboBox<String> userType = new JComboBox<>();
        userType.addItem("Aluno");
        userType.addItem("Funcionário");

        panel.add(userType);

        int option = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Usuário", JOptionPane.OK_CANCEL_OPTION);

        if(option == JOptionPane.OK_OPTION){
            return new UserDTO(name.getText(), email.getText(), phone.getText(), (String) userType.getSelectedItem());
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

        return null;
    }

    @Override
    public void showAllBooks(List<BookDTO> books) {
        String title = "Todos os livros";
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

    @Override
    public void showLoanBooks(List<BookDTO> books) {
        //Deixei para tu, @caio, para poder usar o JTextArea e o JScrollPane.
        //TO-DO
    }

    @Override
    public void showUserWithBook(List<LoanDTO> reserveds) {
        String title = "Livros emprestados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (LoanDTO reserved : reserveds){

            BookDTO book = reserved.getBook();
            UserDTO user = reserved.getUser();

            sb.append("Nome: ").append(user.getName());
            sb.append("Titulo do livro: ").append(book.getTitle());
            sb.append("Edição: ").append(book.getEdition());
            sb.append("Data do emprestimo: ").append(reserved.getAcquiredDate());
            sb.append("Data de devolução: ").append(reserved.getReturnDate());
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
}
