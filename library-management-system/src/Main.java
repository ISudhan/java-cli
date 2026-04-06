import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        BookService bService = new BookService(books);
        UserService uService = new UserService(users);
        while(true){
            System.out.println("\n1. Add Book\n2. View Books\n3. Add User\n4. Issue Book\n5. Return Book\n6. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter book id: ");
                    int bID = sc.nextInt(); 
                    if(bService.isIDAvailable(bID)){
                        sc.nextLine();
                        System.out.print("Enter Book Name: ");
                        String newBookName = sc.nextLine();
                        if(newBookName.trim() == ""){
                            System.out.println("Invalid Name");
                            break;
                        }
                        bService.addBook(bID,newBookName);
                        break;
                    }
                    else System.out.println("ID not available");
                    break;
                
                case "2":
                    bService.viewBooks();
                    break;
                
                case "3":
                    System.out.print("Enter user id: ");
                    int uID = sc.nextInt(); 
                    if(uService.isIDAvailable(uID)){
                        sc.nextLine();
                        System.out.print("Enter user Name: ");
                        String newUserName = sc.nextLine();
                        if(newUserName.trim().isEmpty()){
                            System.out.println("Invalid Name");
                            break;
                        }
                        uService.addUser(uID,newUserName);
                        break;
                    }
                    else System.out.println("ID not available");
                    break;
                    
                case "4":
                    bService.issueBook(uService);
                    break;
                
                case "5":
                    System.out.print("Enter book issued user id: ");
                    int rID = sc.nextInt();
                    bService.returnBook(rID,uService);
                    break;
                
                case "6":
                    System.out.println("Thank You!");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}