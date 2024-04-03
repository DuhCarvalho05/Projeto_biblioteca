package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
import Model.Entity.User;

import java.util.List;

public interface UserDao {
    boolean insert(User user) throws InsertFailedException;
    boolean delete(User user) throws DeleteFailedException;
    List<User> getAll();
    User getById(String email) throws FailedReturnException;
}
