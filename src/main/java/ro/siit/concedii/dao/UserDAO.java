package ro.siit.concedii.dao;


import ro.siit.concedii.domain.User;

//import java.util.Collection;


public interface UserDAO extends BaseDAO<User>{

    User getUserInfo(User user);

}
