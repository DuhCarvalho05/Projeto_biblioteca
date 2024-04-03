package Model.Dao;

import Exceptions.FailedReturnExecption;
import Model.Entity.User;

import java.util.List;

public interface UserDao {
    boolean insert(User user) throws FailedReturnExecption;
    boolean delete(User user) throws FailedReturnExecption;
    List<User> getAll();
    User getById(String email) throws FailedReturnExecption;
}
