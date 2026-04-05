import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class UserService {
    private String idFile = "id.txt";
    private String fileName = "user.csv";

    private int getID(){
        File isAvailableIdFile = new File(idFile);
        if(!isAvailableIdFile.exists()) {
            return 0;
        }

        try(BufferedReader myIdFile = new BufferedReader(new FileReader(idFile))){
            String line;
            if((line = myIdFile.readLine()) != null){
                int maxId = Integer.parseInt(line);
                return maxId;
            }
            System.out.println("No id Found in ID file");
            myIdFile.close();
        }catch(Exception e){
            System.out.println("Error in finding next id "+e);
        }
        return 0;
    }

    private void updateId(int newID){
        try(BufferedWriter myIdFile = new BufferedWriter(new FileWriter(idFile))){
            myIdFile.write(""+newID);
            myIdFile.close();
        }catch(Exception e){
            System.out.println("Error "+e);
        }
    }
    public void addUser(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Invalid name");
            return;
        }
        if(searchUser(0,name)){
            System.out.println("User already Exist");
            return;
        }
        try(BufferedWriter myFile = new BufferedWriter(new FileWriter(fileName,true))){
            int userID = getID()+1;
            updateId(userID);
            myFile.write(userID+","+name);
            myFile.newLine();
            System.out.println("User added Successfully");
        }
        catch(IOException e){
            System.out.println("Error writing file."+e);
        }
    }

    public void viewUsers(){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            System.out.println("User not exist");
            return;
        }
        try(BufferedReader myFile = new BufferedReader(new FileReader(fileName))) {
            System.out.println("User List:");
            String line;
            while((line = myFile.readLine()) != null){
                System.out.println("ID: "+line.split(",")[0]+" Name: "+line.split(",")[1]);
            }
        } catch (Exception e) {
            System.out.println("Error reading file."+e);
        }
    }
    public void deleteUser(int delID){
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
            while((line = myFileRead.readLine()) != null){
                if(Integer.parseInt(line.split(",")[0]) != delID){
                    myFileWrite.write(line);
                    myFileWrite.newLine();
                }
                else found = true;
            }
            myFileWrite.close();
            myFileRead.close();
            if(!found){
                System.out.println("User not exist");
                tempFile.delete();
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
    public boolean searchUser(int userId,String name){
        File isAvailaFile = new File(fileName);
        if(!isAvailaFile.exists()) {
            return false;
        }
        try(BufferedReader myFile = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=myFile.readLine()) != null){
                if(userId != 0 && !name.isEmpty()) {
                if(Integer.parseInt(line.split(",")[0]) == userId && line.split(",")[1].equalsIgnoreCase(name)) return true;
                } else if(userId != 0) {
                    if(Integer.parseInt(line.split(",")[0]) == userId) return true;
                } else if(!name.isEmpty()) {
                    if(line.split(",")[1].equalsIgnoreCase(name)) return true;
                }
            }

        }catch(Exception e){
            System.out.println("Error in file opening "+e);
        }
        return false;
    }
    public void updateUser(int id,String newName){
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
                if(Integer.parseInt(line.split(",")[0]) != id) {
                    myFileWrite.write(line);
                    myFileWrite.newLine();
                }
                else {
                    myFileWrite.write(line.split(",")[0]+","+newName);
                    myFileWrite.newLine();
                    found = true;
                }
            }
            myFileWrite.close();
            myFileRead.close();
            if(!found){
                System.out.println("Cannot update user not exist");
                tempFile.delete();
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