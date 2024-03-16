package Model.Dao;

import Model.Entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private static List<User> dataset;

    public UserDaoImpl(){
        //TODO
    }

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean insert(User user) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(User user) {
        //TODO
        return false;
    }

    @Override
    public List<User> getAll() {
        //TODO
        return null;
    }

    @Override
    public List<User> getById(String email) {
        //TODO
        return null;
    }
}
