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

        if(service.insert(user.toDomain())) {
            view.succes();
        } else {
            view.fail();
        }
    }

    // TODO: Verify if this will be the correct way to show all users
    public void getAll() {
        List<User> users = service.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(new UserDTO(user));
        }
        view.showAllUsers(usersDTO);
    }

    public void deleteUser() {
        var user = view.readUser();
        if(service.delete(user.toDomain())) {
            view.succes();
        } else {
            view.fail();
        }
    }

    public void getUserById() {
        var user = view.readUser();
        User userById = service.getById(user.getEmail());
        UserDTO userDTO = new UserDTO(userById);
        view.showUserById(userDTO);
    }

}
