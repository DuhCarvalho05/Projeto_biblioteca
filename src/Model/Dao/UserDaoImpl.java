package Model.Dao;

import Exceptions.ReturnFailedException;

import Model.Entity.Employee;
import Model.Entity.Student;
import Model.Entity.User;
import Model.Enum.UserType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;
    private final Collection<User> dataset;

    public UserDaoImpl(){
        dataset =  new TreeSet<>();
    }

    public static UserDaoImpl getInstance() {
        if(instance == null)
            instance = new UserDaoImpl();

        return instance;
    }

    @Override
    public Boolean insert(User user) {
        if (user != null){
            if (user.getUserType().equals(UserType.EMPLOYEE)) {
                return dataset.add(new Employee(user.getName(),
                        user.getEmail(),
                    user.getPhone()));
            } else {
                return dataset.add(new Student(user.getName(), user.getEmail(),
                    user.getPhone()));
            }
        }

        return false;
    }

    @Override
    public Boolean delete(User user) {
        if (user != null)
            return dataset.remove(user);

        return false;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public User getById(String email) throws ReturnFailedException {
        for (User u : dataset){
            if (u.getEmail().equals(email)){
                if (u.getUserType().equals(UserType.EMPLOYEE)) {
                    return new Employee(u.getName(), u.getEmail(),
                            u.getPhone());
                } else {
                    return new Student(u.getName(), u.getEmail(),
                            u.getPhone());
                }
            }
        }
        throw new ReturnFailedException("Não foi possível encontrar usuário.");
    }
}