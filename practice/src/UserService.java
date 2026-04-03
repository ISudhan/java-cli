import java.util.*;

public class UserService {
    ArrayList<User> users = new ArrayList<>();

    public void addUser(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }

        for(User u:users){
            if(u.name.equals(name)) {
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
            System.out.println(i+1 + ". " + users.get(i).name);
        }
    }
    
    public void deleteUser(String name){
        for(int i = 0;i<users.size();i++){
            if(users.get(i).name.equals(name)){
                users.remove(i);
                System.out.println("User removed Successfully!");
                return;
            }
        }
        System.out.println("User Not Found");
    }
}