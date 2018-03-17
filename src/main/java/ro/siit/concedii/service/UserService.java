package ro.siit.concedii.service;

import ro.siit.concedii.domain.User;

import java.util.Collection;

public interface UserService {


    public boolean delete(Long id) ;

    public User get(Long id) ;

    public void save(User user)throws ValidationException;

    public boolean update(User user, Long id) throws ValidationException;

    public boolean isAuthentificated(String username, String password);
}
