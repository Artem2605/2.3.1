package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> getListOfUsers();

    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);
}