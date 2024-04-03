package Model.Service;

import Exceptions.FailedReturnExecption;
import Model.Dao.UserDao;
import Model.Dao.UserDaoImpl;
import Model.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDao dao;

    public UserService(){
        dao = UserDaoImpl.getInstance();
    }

    public Boolean insert(User user) throws FailedReturnExecption {
        return dao.insert(user);
    }
    public Boolean delete(User user) throws FailedReturnExecption {
        return dao.delete(user);
    }
    public List<User> getAll(){
        return dao.getAll();
    }
    public User getById(String id) throws FailedReturnExecption {
        return dao.getById(id);
    }
    public List<User> getPenalizedUsers(){
        List<User> l = new ArrayList<>();
        for (User u: getAll()){
            if (u.getPenalty() > 0){
                l.add(u);
            }
        }
        return l;
    }

}
