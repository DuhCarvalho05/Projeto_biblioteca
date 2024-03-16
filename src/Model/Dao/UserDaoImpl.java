package Model.Dao;

import Model.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private static Set<User> dataset;

    public UserDaoImpl(){
        dataset = new TreeSet<>();
    }

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return dataset.add(user);
    }

    @Override
    public boolean delete(User user) {
        //TODO
        return false;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public User getById(String email) {
        //TODO
        return null;
    }
}
