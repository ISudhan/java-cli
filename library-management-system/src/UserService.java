import java.util.ArrayList;

public class UserService {
    ArrayList<User> userList;
    UserService(ArrayList<User> userList){
        this.userList = userList;
    }
    public boolean isIDAvailable(int uid){
        for(User l:userList){
            if(l.id == uid) return false;
        }
        return true;
    }

    public void addUser(int uID,String newUserName){
        User newUser = new User(uID,newUserName);
        userList.add(newUser);
        System.out.println("User added successfully");
    }
}
