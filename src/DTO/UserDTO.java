package DTO;

import Model.Entity.Employee;
import Model.Entity.Student;
import Model.Entity.User;

public class UserDTO {

    private String name;
    private String email;
    private int telefone;
    private User userType;
    private int penalty;

    public UserDTO(String name, String email, int telefone, User userType, int penalty) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.userType = userType;
        this.penalty = penalty;
    }

    public UserDTO(User domain){
        this.name = domain.getName;
        this.email = domain.getEmail;
        this.telefone = domain.getTelefone;
        this.userType = domain.getUserType;
        this.penalty = domain.getPenalty;
    }

    public User toDomain(){
        if(userType instanceof Student){
            return new Student(name, email, telefone);
        } else if (userType instanceof Employee) {
            return new Employee(name, email, telefone);
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public User getUserType() {
        return userType;
    }

    public void setUserType(User userType) {
        this.userType = userType;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }
}
