import java.util.*;

public class UserService {
    ArrayList<User> users = new ArrayList<>();

    public void addUser(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }

        users.add(new User(name));
        System.out.println("User " + name + " added successfully");
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found");
            return;
        }

        System.out.println("User List:");
        for (User u : users) {
            System.out.println(u.name);
        }
    }
}