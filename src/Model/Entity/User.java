package Model.Entity;

import Model.UserType;

public abstract class User implements Comparable<User> {
    protected String name;
    protected String email;
    protected int phone;
    protected int penalty;

    public User(String name, String email, int phone, int penalty) {
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

    public int getPhone() {
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
        if (user != null) {
            return this.equals(user) ? 0 : this.email.compareTo(user.email);
        }
        return 0;
    }
}
