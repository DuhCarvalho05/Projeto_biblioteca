package Model.Dao;

import Exceptions.DeleteFailedException;
import Exceptions.FailedReturnException;
import Exceptions.InsertFailedException;
import Model.Entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private final Collection<User> dataset;

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
    public boolean insert(User user) throws InsertFailedException {
        if (user != null){
            return dataset.add(user);
        }

        throw new InsertFailedException("Não foi possível inserir usuário.");
    }

    @Override
    public boolean delete(User user) throws DeleteFailedException {
        if (user != null){
            return dataset.remove(user);
        }
        throw new DeleteFailedException("Não foi possível deletar usuário.");
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(dataset);
    }

    @Override
    public User getById(String email) throws FailedReturnException {
        for (User u : dataset){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        throw new FailedReturnException("Usuário não encontrado.");
    }
}
