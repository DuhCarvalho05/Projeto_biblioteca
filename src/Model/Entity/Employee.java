package Model.Entity;

public class Employee extends User{
    public Employee(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.penalty = 0;
    }

    public int getDeadline() {
        return 15;
    }
}
