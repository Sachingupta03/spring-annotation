package cam.sachin.cab.annotation.controller;

import cam.sachin.cab.annotation.model.User;
import cam.sachin.cab.annotation.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
@Setter
public class UserController {

    @Autowired
    private UserService userService;

    private final Scanner scanner = new Scanner(System.in);

    public void userMenu() {
        int choice;
        do {
            System.out.println("\n--- USER MANAGEMENT ---");
            System.out.println("1. Register User");
            System.out.println("2. Show All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> listUsers();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid input. Try again.");
            }
        } while (choice != 0);
    }

    private void registerUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        User user = new User(userId,name, address,phoneNumber);
        userService.registerUser(user);
    }

    private void listUsers() {
        List<User> users = userService.fetchAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private void updateUser() {
        System.out.print("Enter User ID to Update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Updated Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Updated Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Updated Phone Number: ");
        String phoneNumber = scanner.nextLine();

        User user = new User(userId,name, address,phoneNumber);
        userService.modifyUser(user);
    }

    private void deleteUser() {
        System.out.print("Enter User ID to Delete: ");
        int userId = scanner.nextInt();
        userService.removeUser(userId);
    }
}
