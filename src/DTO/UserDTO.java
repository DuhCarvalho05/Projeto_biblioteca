package DTO;

import Model.Entity.Employee;
import Model.Entity.Student;
import Model.Entity.User;
import Model.UserType;

public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private UserType userType;
    private int penalty;

    public UserDTO(String name, String email, String phone, UserType userType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
        this.penalty = 0;
    }

    public UserDTO(User domain){
        this.name = domain.getName();
        this.email = domain.getEmail();
        this.phone = domain.getPhone();
        this.penalty = domain.getPenalty();
    }

    public User toDomain(){
        if(userType == UserType.EMPLOYEE){
            return new Student(name, email, phone);
        } else if (userType == UserType.STUDENT) {
            return new Employee(name, email, phone);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
