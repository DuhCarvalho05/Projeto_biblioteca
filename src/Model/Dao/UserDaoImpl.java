package Model.Dao;

import Model.Entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private static Collection<User> dataset;

    public UserDaoImpl(){
        dataset =  new TreeSet<>();
    }

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(User user) {
        if (user != null){
         return dataset.add(user);
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        if (user != null){
            return dataset.remove(user);
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public User getById(String email) {
        for (User u : dataset){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
}
