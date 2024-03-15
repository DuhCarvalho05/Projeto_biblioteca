package Model.Entity;

public class Student extends User{
    public Student(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.penalty = 0;
    }
    
    public int getDeadline() {
        return 5;
    }
}
