package ro.siit.concedii.service;

import ro.siit.concedii.dao.UserDAO;
import ro.siit.concedii.domain.User;


public class UserServiceIMPL implements UserService {

    private UserDAO dao;


    @Override
    public User get(Long id) {
        return new User();

    }

    @Override
    public void save(User user){
        dao.add(user);
    }

    @Override
    public boolean update(User employee, Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean isAuthentificated(String username, String password) {
        return false;
    }
}
