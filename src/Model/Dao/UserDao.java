package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.ReturnFailedException;
import Exceptions.InsertFailedException;
import Model.Entity.User;

import java.util.List;

public interface UserDao {
    Boolean insert(User user) throws InsertFailedException;
    Boolean delete(User user) throws DeleteFailedException;
    List<User> getAll();
    User getById(String email) throws ReturnFailedException;
}
