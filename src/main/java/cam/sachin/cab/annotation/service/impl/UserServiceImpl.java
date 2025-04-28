package cam.sachin.cab.annotation.service.impl;

import cam.sachin.cab.annotation.model.User;
import cam.sachin.cab.annotation.repository.UserRepository;
import cam.sachin.cab.annotation.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
        System.out.println("User registered successfully!");
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void modifyUser(User user) {
        userRepository.updateUser(user);
        System.out.println("User updated successfully!");
    }

    @Override
    public void removeUser(int userId) {
        userRepository.delete(userId);
        System.out.println("User removed successfully!");
    }
}
