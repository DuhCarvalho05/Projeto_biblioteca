package Model.Entity;

public class Employee extends User{

    public Employee(String name, String email, int phone) {
        super(name, email, phone, 0);
    }

    public int getDeadline() {
        return 15;
    }
}
