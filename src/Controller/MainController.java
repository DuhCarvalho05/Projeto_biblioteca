package Controller;

import Model.Dao.*;
import Model.Entity.Book;
import Model.Entity.Employee;
import Model.Entity.Student;
import View.IView;
import View.PanelView;

public class MainController {

    private BookController bookController;
    private LoanController loanController;
    private UserController userController;

    private BookDao bookDao;
    private UserDao userDao;

    IView view;

    public MainController() {
        view = new PanelView();
        bookController = new BookController(view);
        loanController = new LoanController(view);
        userController = new UserController(view);

        bookDao = BookDaoImpl.getInstance();
        userDao = UserDaoImpl.getInstance();


    }

    public void run() {
        boolean stop = false;

        load();

        while (!stop){
            switch (view.showMenu()){
                case INSERT_BOOK:
                    bookController.createBook();
                    break;
                case INSERT_USER:
                    userController.createUser();
                    break;
                case RESERVE_BOOK:
                    loanController.createLoan();
                    break;
                case LOGS:
                    showLogs();
                    break;
                case QUIT:
                    stop = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void showLogs() {

        switch (view.showMenuLogs()){
            case ALL_BOOKS:
                bookController.getAll();
                break;
            case RESERVED_BOOKS:
                bookController.getAll();
                break;
            case USER_WITH_BOOK:
                loanController.getAll();
                break;
            case USER_WITH_PENALITY:
                userController.getAllPenalized();
                break;
            case LATE_BOOKING:
                loanController.getAllLateLoans();
                break;
            default:
                break;
        }
    }

    private void load(){
        bookDao.insert(new Book("Harry Potter", 3, "J.K Rowling", true, 0));
        bookDao.insert(new Book("Senhor dos aneis", 1, "sei la", true, 0));
        bookDao.insert(new Book("Dracula", 10, "Um véio", true, 0));
        bookDao.insert(new Book("A turma da Mônica", 26, "Mauricio de Souza", true, 0));

        userDao.insert(new Employee("Ednilson", "ednilsonrossi@gmail.com", "123456789"));
        userDao.insert(new Employee("Furquim", "furquim@gmail.com", "987654321"));
        userDao.insert(new Student("Augusto", "guto@gmail.com", "1111111111"));
        userDao.insert(new Student("Caio", "caio@gmail.com", "222222222"));

    }

}
