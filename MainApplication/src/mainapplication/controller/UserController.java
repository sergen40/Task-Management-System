package mainapplication.controller;

import java.util.ArrayList;
import mainapplication.dao.IDaoConnection;
import mainapplication.dao.UserDao;
import mainapplication.model.User;

/**
 *
 * @author Rita
 */
public class UserController  {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public ArrayList<User> getList() {
        return userDao.getList();
    }

    public User get(int id) {
        return userDao.get(id);
    }
    
    public User getUserWithPasswordAndUsername(int password, String username){
        return userDao.getUserWithPasswordAndUsername(password, username);
    }


}
