package View;

import java.awt.*;
import java.util.List;
import DTO.*;
import Model.Entity.User;
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
        JTextField userType = new JTextField();

        panel.add(new Label("Nome:"));
        panel.add(name);
        panel.add(new Label("Email:"));
        panel.add(email);
        panel.add(new Label("Telefone:"));
        panel.add(phone);
        panel.add(new Label("Tipo de usuário:"));
        panel.add(userType);

        int option = JOptionPane.showConfirmDialog(null, panel, "Cadastrar Usuário", JOptionPane.OK_CANCEL_OPTION);

        if(option == JOptionPane.OK_OPTION){
            return new UserDTO(name.getText(), email.getText(), phone.getText(), userType.getText(), 0);
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
    public LoanDTO readReserve(List<BookDTO> books, List<UserDTO> users) {
        return null;
    }

    @Override
    public void showAllBooks(List<BookDTO> books) {
        String title = "Todos os livros"
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

        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void showReservedBooks(List<BookDTO> books) {
        //Deixei para tu, @caio, para poder usar o JTextArea e o JScrollPane.

        //Depois q tu fizer, precisamos criar uma função aqui, só para o JtextArea,
        // o código se repete diversas vezes, então o ideal ser criar uma função, mas vou deixar
        // para criar depois de você fazer aqui :)

        //TO-DO
    }

    @Override
    public void showUserWithBook(List<LoanDTO> reserveds) {
        String title = "Livros emprestados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (LoanDTO reserved : reserveds){
            //TO-DO
            sb.append("------------------------------------------------------------------------\n");
        }

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

        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showUserWithPenality(List<UserDTO> penalizeds) {
        String title = "Usuários sendo penalizados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (UserDTO userP : penalizeds){
            sb.append("Nome: ").append(userP.getName()).append("\n");
            sb.append("E-mail: ").append(userP.getEmail()).append("\n");
            sb.append("Telefone: ").append(userP.getTelefone()).append("\n");
            sb.append("Tipo de usuário: ").append(userP.getUserType()).append("\n");
            sb.append("Dias de penalidade restantes: ").append(userP.getPenalty()).append("\n");
            sb.append("------------------------------------------------------------------------\n");
        }

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

        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showLateBooking(List<LoanDTO> late) {
        String title = "Usuários sendo penalizados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (){
            sb.append("------------------------------------------------------------------------\n");
        }

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

        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
