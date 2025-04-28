package cam.sachin.cab.annotation.repository;

import cam.sachin.cab.annotation.model.User;

import java.util.List;

public interface UserRepository {
    void save(User user);              // Save a new user
    List<User> findAll();              // Find all users
    User findById(int id);             // Find user by ID
    void delete(int id);               // Delete a user by ID
    void updateUser(User user);        // Update user details
}
