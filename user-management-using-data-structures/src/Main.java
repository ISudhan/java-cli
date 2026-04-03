import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        UserService service = new UserService();

        while (true) {
            System.out.println("\n1. Add User\n2. View Users\n3. Delete User\n4. Exit");
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
                        sc.nextLine(); // consume newline
                        service.deleteUser(index - 1);
                    } else {
                        System.out.println("Invalid input");
                        sc.nextLine(); // clear garbage
                    }
                    break;
                    
                case "4":
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}