package cam.sachin.cab.annotation.service;

import cam.sachin.cab.annotation.model.User;
import java.util.List;

public interface UserService {
    void registerUser(User user);
    List<User> fetchAllUsers();
    void modifyUser(User user);
    void removeUser(int userId);
}
