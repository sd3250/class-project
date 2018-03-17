package ro.siit.concedii.service;

import ro.siit.concedii.domain.User;

import java.util.Collection;

public interface UserService {

    // TODO @Dan: Why do we need these 2 for a user?
//    public Collection<Employee> listAll();
//    public Collection<Employee> search( String query) ;

    public boolean delete(Long id) ;

    public User get(Long id) ;

    public void save(User user)throws ValidationException;

    public boolean update(User user, Long id) throws ValidationException;

    public boolean isAuthentificated(String username, String password);
}
