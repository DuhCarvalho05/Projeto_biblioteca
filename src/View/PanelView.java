package View;

import java.awt.*;
import java.util.List;
import DTO.*;
import View.Enum.MenuOptions;

import javax.swing.*;

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

        JOptionPane.showMessageDialog(null, panelBuilder(sb), title, JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void showReservedBooks(List<BookDTO> books) {
        //Deixei para tu, @caio, para poder usar o JTextArea e o JScrollPane.
        //TO-DO
    }

    @Override
    public void showUserWithBook(List<LoanDTO> reserveds) {
        String title = "Livros emprestados";
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------------------------------------\n");
        for (LoanDTO reserved : reserveds){
            sb.append("Nome: ").append(reserved.getUser().getName());
            sb.append("Titulo do livro: ").append(reserved.getBook().getTitle());
            sb.append("Edição: ").append(reserved.getBook().getEdition());
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
