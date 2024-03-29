package DTO;

import Model.Entity.Book;
import Model.Entity.Employee;
import Model.Entity.Student;
import Model.Entity.User;
import Model.Enum.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private UserType userType;
    private int penalty;

    public UserDTO(String name, String email, String phone, String userType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userType = userType.equals("Aluno") ? UserType.STUDENT : UserType.EMPLOYEE;
        this.penalty = 0;
    }

    public UserDTO(User domain){
        this.name = domain.getName();
        this.email = domain.getEmail();
        this.phone = domain.getPhone();
        this.penalty = domain.getPenalty();
        this.userType = domain.getUserType();
    }

    public User toDomain(){
        if(userType == UserType.EMPLOYEE){
            return new Employee(name, email, phone);
        } else if (userType == UserType.STUDENT) {
            return new Student(name, email, phone);
        }
        return null;
    }

    public static List<UserDTO> toDomain(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(new UserDTO(user));
        }

        return usersDTO;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    public String getUserType() {
        return userType.getValue();
    }


    public int getPenalty() {
        return penalty;
    }

}
