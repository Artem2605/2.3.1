package web.dao;

import web.model.User;
import java.util.List;

public interface UserDAO {

    List<User> getListOfUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);
}