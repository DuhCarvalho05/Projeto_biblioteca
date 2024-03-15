package Model.Entity;

public abstract class User {
    protected String name;
    protected String email;
    protected int phone;
    protected int penalty;

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
}
