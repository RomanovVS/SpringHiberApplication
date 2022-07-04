package Java.DAO;

import Java.model.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void deleteUser(Long id);
    List<User> showAllUsers();
    void editUser(Long id, User user);
    User getUserById(Long id);
}
