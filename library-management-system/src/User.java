import java.util.ArrayList;

public class User {
    int id;
    String name;
    ArrayList<Book> issuedBooks = new ArrayList<>();
    User(int id,String name){
        this.id = id;
        this.name = name;
    }
}
