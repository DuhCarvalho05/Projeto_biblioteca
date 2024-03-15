package Model.Entity;

public class Student extends User{

    public Student(String name, String email, int phone) {
        super(name, email, phone, 0);
    }

    public int getDeadline() {
        return 5;
    }
}
