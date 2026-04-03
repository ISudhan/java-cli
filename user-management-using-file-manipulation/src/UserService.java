import java.util.*;

public class UserService {
    ArrayList<User> users = new ArrayList<>();

    public void addUser(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }

        for(User u:users){
            if(u.getName().equals(name)) {
                System.out.println("User already Exist");
                return;
            }
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
        for (int i = 0;i<users.size();i++) {
            System.out.println(i+1 + ". " + users.get(i).getName());
        }
    }
    
    public void deleteUser(int index){
        if (index < 0 || index >= users.size()) {
            System.out.println("Invalid index");
            return;
        }
        String removedName = users.get(index).getName();    
        users.remove(index);
        System.out.println("User " + removedName + " removed successfully!");
    }
}