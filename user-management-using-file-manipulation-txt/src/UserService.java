import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class UserService {
    private String fileName = "user.txt";
    public void addUser(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }
        if(searchUser(name) == 1){
            System.out.println("User already Exist");
            return;
        }
        try(BufferedWriter myFile = new BufferedWriter(new FileWriter(fileName,true))){
            myFile.write(name);
            myFile.newLine();
            System.out.println("User added Successfully");
            myFile.close();
        }
        catch(IOException e){
            System.out.println("Error writing file."+e);
        }
    }

    public void viewUsers(){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            System.out.println("File not exist");
            return;
        }
        try(BufferedReader myFile = new BufferedReader(new FileReader(fileName))) {
            System.out.println("User List:");
            String line;
            for(int i=1;(line = myFile.readLine()) != null;i++){
                System.out.println(i+". "+line);
            }
            myFile.close();

        } catch (Exception e) {
            System.out.println("Error reading file."+e);
        }
    }
    public void deleteUser(int n){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            System.out.println("File not exist");
            return;
        }
        try {
            File userFile = new File(fileName);
            File tempFile = new File("temp.txt");
            BufferedReader myFileRead = new BufferedReader(new FileReader(fileName));
            BufferedWriter myFileWrite = new BufferedWriter(new FileWriter("temp.txt"));
            System.out.println("User List:");
            String line;
            boolean found = false;
            for(int i = 1;(line = myFileRead.readLine()) != null;i++){
                if(i != n){
                    myFileWrite.write(line);
                    myFileWrite.newLine();
                }
                else found = true;
            }
            myFileWrite.close();
            myFileRead.close();
            if(!found){
                System.out.println("User not exist");
                return;
            }
            if(userFile.delete()){
                if(tempFile.renameTo(userFile)){
                    System.out.println("User deleted Successfully");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file."+e);
        }
    }
    public int searchUser(String userName){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            System.out.println("File not exist");
            return 0;
        }
        try(BufferedReader myFile = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=myFile.readLine()) != null){
                if(line.equalsIgnoreCase(userName)){
                    myFile.close();
                    return 1;
                }
            }
        }catch(Exception e){
            System.out.println("Error in file opening "+e);
        }
        return 0;
    }
    public void updateUser(String oldName,String newName){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            System.out.println("File not exist");
            return;
        }
        try {
            File userFile = new File(fileName);
            File tempFile = new File("temp.txt");
            BufferedReader myFileRead = new BufferedReader(new FileReader(fileName));
            BufferedWriter myFileWrite = new BufferedWriter(new FileWriter("temp.txt"));
            System.out.println("User List:");
            String line;
            boolean found = false;
            while((line=myFileRead.readLine()) != null){
                if(!line.equalsIgnoreCase(oldName)) {
                    myFileWrite.write(line);
                    myFileWrite.newLine();
                }
                else {
                    myFileWrite.write(newName);
                    found = true;
                }
            }
            myFileWrite.close();
            myFileRead.close();
            if(!found){
                System.out.println("Cannot update user not exist");
                return;
            }
            else{
                if(userFile.delete() && tempFile.renameTo(userFile)){
                    System.out.println("User updated Successfully");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file."+e);
        }
    }

}