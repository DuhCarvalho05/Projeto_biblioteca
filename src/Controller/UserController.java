package Controller;

import DTO.UserDTO;
import Model.Entity.User;
import Model.Service.UserService;
import View.IView;
import View.PanelView;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    UserService service;
    IView view;

    public UserController() {
        service = new UserService();
        view = new PanelView();
    }

    public void createUser() {
        var user = view.readUser();
        view.alertScreen(service.insert(user.toDomain()));
    }

}
