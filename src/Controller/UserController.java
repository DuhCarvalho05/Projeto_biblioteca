package Controller;

import DTO.UserDTO;
import Model.Service.UserService;
import View.IView;

public class UserController {
    UserService service;
    IView view;

    public UserController(IView view) {
        service = new UserService();
        this.view = view;
    }

    public void createUser() {
        var user = view.readUser();

        if(user == null) {
            view.showMessage("Operação cancelada", "Operação cancelada");
        } else {
            view.alertScreen(service.insert(user.toDomain()));
        }
    }

    public void getAllPenalized() {
        var usersDTO = UserDTO.toDomain(service.getAll());
        view.showUserWithPenality(usersDTO);
    }

}
