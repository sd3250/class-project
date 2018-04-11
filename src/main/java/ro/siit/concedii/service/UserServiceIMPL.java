package ro.siit.concedii.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.siit.concedii.dao.UserDAO;
import ro.siit.concedii.domain.User;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserDAO dao;

    public Collection<User> listAll() {
        return dao.getAll();
    }

    @Override
    public User get(Long id) {
        return dao.findById(id);
    }

    @Override
    public void save(User user){
        dao.add(user);
    }

    @Override
    public boolean update(User user, Long id) {
        return dao.update(user, id);
    }

    @Override
    public boolean delete(Long id) {
        User user = dao.findById(id);
        return (user != null && dao.delete(user));
    }

    @Override
    public boolean isAuthentificated(String username, String password) {
        return true;
    }
}
