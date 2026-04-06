import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> bookList;
    BookService(ArrayList<Book> bookList){
        this.bookList = bookList;
    }
    public boolean isIDAvailable(int bid){
        for(Book l:bookList){
            if(l.id == bid) return false;
        }
        return true;
    }

    public void addBook(int bid,String newBookName){
        Book newBook = new Book(bid,newBookName);
        bookList.add(newBook);
        System.out.println("Book added Successfully");
    }

    public void viewBooks(){
        System.out.println("All Book List:");
        for(Book l:bookList){
            System.out.println("ID: "+l.id+" Name: "+l.name);
        }
    }

    public void issueBook(UserService uService){
        System.out.println("Available Books");
        for(Book l:bookList){
            if(!l.isIssued) System.out.println("ID: "+l.id+" Name: "+l.name);
        }
        System.out.print("Choose ID to issue: ");
        int issueID = sc.nextInt(); 
        for(User u:uService.userList){
            System.out.println("UserID: "+u.id+" Name: "+u.name);
        }
        System.out.print("Choose UserID issued by: ");
        int userIssuedID = sc.nextInt();

        for(User u:uService.userList){
            if(u.id == userIssuedID){
                for(Book l:bookList){
                    if(!l.isIssued && l.id == issueID){
                        l.isIssued = true;
                        u.issuedBooks.add(l);
                        System.out.println("Book issued successfully");
                        return;
                    }
                }
            }
        }
    }

    public void returnBook(int id,UserService uService){
        Book rb=null;
        User ul=null;
        boolean found=false;
        for(User u:uService.userList){
            if(u.id == id){
                if(u.issuedBooks.size() == 0){
                    System.out.println("No Books issued");
                    return;
                }
                System.out.println("Issued Books");
                for(Book b:u.issuedBooks){
                    System.out.println("ID: "+b.id+" Name: "+b.name);
                }
                System.out.print("Choose book that wants to be returned: ");
                int brID = sc.nextInt();
                for(Book b:u.issuedBooks){
                    if(b.id == brID){
                        b.isIssued = false;
                        found = true;
                        rb = b;
                        ul = u;
                    }
                }
                System.out.println("Book returned successfully");
                break;
            }
        }
        if(found)
        ul.issuedBooks.remove(rb);
        return;          
    }
}
