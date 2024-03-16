package Model.Service;

import Model.Dao.UserDao;
import Model.Dao.UserDaoImpl;
import Model.Entity.User;

import java.util.List;

public class UserService {
    private UserDao dao;

    public UserService(){
        dao = UserDaoImpl.getInstance();
    }

    public Boolean insert(User user){
        return dao.insert(user);
    }
    public Boolean delete(User user){
        return dao.delete(user);
    }
    public List<User> getAll(){
        return dao.getAll();
    }
    public User getById(String id){
        return dao.getById(id);
    }
}
