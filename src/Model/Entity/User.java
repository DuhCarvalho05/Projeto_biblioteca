package Model.Entity;

import Model.UserType;

public abstract class User {
    protected String name;
    protected String email;
    protected String phone;
    protected int penalty;

    public User(String name, String email, String phone, int penalty) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.penalty = penalty;
    }

    public int getPenalty() {
        return penalty;
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

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public abstract int getDeadline();

    public abstract UserType getUserType();

}
