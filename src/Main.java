import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Your Age: ");
        boolean eligible=false;;
        if(sc.hasNextInt()){
            int age = sc.nextInt();
            if(age<0){
                System.out.println("Invalid Age");
                return;
            }
            if(age>120){
                System.out.println("Unrealistic Age");
                return;
            }
            if(age>=18) eligible=true;
        }
        System.out.println("Hello "+name);
        String p = eligible?"Eligible":"Not Eligible";
        System.out.println("You're "+p);
        sc.close();
    }
}
