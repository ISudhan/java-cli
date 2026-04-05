import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        UserService service = new UserService();

        while (true) {
            System.out.println("\n1. Add User\n2. View Users\n3. Delete User\n4. Search User\n5. Update User\n6. Exit\n");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    service.addUser(name);
                    break;

                case "2":
                    service.viewUsers();
                    break;

                case "3":
                    service.viewUsers();
                    System.out.print("Enter index to delete: ");
                    
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();
                        sc.nextLine(); 
                        service.deleteUser(index);
                    } else {
                        System.out.println("Invalid input");
                        sc.nextLine();
                    }
                    break;

                case "4":
                    System.out.print("Enter user name: ");
                    String userName = sc.nextLine();
                    if(service.searchUser(userName) == 1) System.out.println("Found");
                    else System.out.println("User not in the list");
                    break;
                
                case "5":
                    System.out.println("Enter old user name: ");
                    String oldName = sc.nextLine();
                    System.out.println("Enter new user name: ");
                    String newName = sc.nextLine();
                    service.updateUser(oldName,newName);                    
                    break;
                
                case "6":
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}