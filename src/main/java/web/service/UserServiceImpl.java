package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO USER_DAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.USER_DAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListOfUsers() {
        System.out.println("Get list of user's");
        return USER_DAO.getListOfUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        USER_DAO.addUser(user);
        System.out.println("User " + user.getFirstName() + " add");
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        System.out.println("Get user " + id);
        return USER_DAO.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        USER_DAO.updateUser(user);
        System.out.println("User " + user.getId() + " update");
    }

    @Transactional
    @Override
    public void deleteUserById(Long id) {
        USER_DAO.deleteUserById(id);
        System.out.println("Delete user " + id);
    }
}