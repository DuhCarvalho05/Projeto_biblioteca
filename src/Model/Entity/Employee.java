package Model.Entity;

import Model.UserType;

public class Employee extends User{

    public Employee(String name, String email, int phone) {
        super(name, email, phone, 0);
    }

    @Override
    public int getDeadline() {
        return 15;
    }

    @Override
    public UserType getUserType() {
        return UserType.EMPLOYEE;
    }
}
