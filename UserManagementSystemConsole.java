import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;
    String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

public class UserManagementSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nUser Management System");
            System.out.println("1. Add a new user");
            System.out.println("2. View all users");
            System.out.println("3. Update a user");
            System.out.println("4. Remove a user");
            System.out.println("5. Search for a user by username");
            System.out.println("6. View users by role");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    searchUserByUsername();
                    break;
                case 6:
                    viewUsersByRole();
                    break;
                case 7:
                    System.out.println("Exiting User Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void addUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (admin, moderator, user): ");
        String role = scanner.nextLine();

        User user = new User(username, password, role);
        users.add(user);

        System.out.println("User added successfully!");
    }

    private static void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("All Users:");
            for (int i = 0; i < users.size(); i++) {
                printUserDetails(i + 1, users.get(i));
            }
        }
    }

    private static void updateUser() {
        viewAllUsers();
        System.out.print("Enter the user number to update: ");
        int userNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (userNumber >= 1 && userNumber <= users.size()) {
            User user = users.get(userNumber - 1);

            System.out.print("Enter new username: ");
            user.username = scanner.nextLine();

            System.out.print("Enter new password: ");
            user.password = scanner.nextLine();

            System.out.print("Enter new role (admin, moderator, user): ");
            user.role = scanner.nextLine();

            System.out.println("User updated successfully!");
        } else {
            System.out.println("Invalid user number.");
        }
    }

    private static void removeUser() {
        viewAllUsers();
        System.out.print("Enter the user number to remove: ");
        int userNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (userNumber >= 1 && userNumber <= users.size()) {
            users.remove(userNumber - 1);
            System.out.println("User removed successfully!");
        } else {
            System.out.println("Invalid user number.");
        }
    }

    private static void searchUserByUsername() {
        System.out.print("Enter username to search: ");
        String searchUsername = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).username.equals(searchUsername)) {
                printUserDetails(i + 1, users.get(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User not found with the given username.");
        }
    }

    private static void viewUsersByRole() {
        System.out.print("Enter role to filter (admin, moderator, user): ");
        String filterRole = scanner.nextLine();

        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("Users with Role '" + filterRole + "':");
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).role.equals(filterRole)) {
                    printUserDetails(i + 1, users.get(i));
               
