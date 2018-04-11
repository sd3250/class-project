package ro.siit.concedii.dao;


import ro.siit.concedii.domain.User;


public interface UserDAO extends BaseDAO<User>{

    User getUserInfo(User user);

}
