package Model.Dao;

import Model.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements UserDao {
    private static UserDaoImpl instance;

    private void ActorDaoImpl(){
        List<User> userList = new ArrayList<>();
    }

    public static userDaoImpl getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User object) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getById(User object) {
        return null;
    }
}
