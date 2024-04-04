package Model.Entity;

import Model.Enum.UserType;

public abstract class User implements Comparable<User> {
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

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int compareTo(User user){
        return user == null ? 0 :
                this.getEmail().replace(" ", "").toUpperCase().compareTo(user.getEmail().replace(" ", "").toUpperCase());
    }
}
