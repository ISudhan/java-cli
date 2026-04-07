import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of Slots: ");
        int slotCount = sc.nextInt();
        sc.nextLine();
        ParkingSlot pSlot = new ParkingSlot(slotCount);
        ParkingService ps = new ParkingService(pSlot);
        while(true){
            System.out.println("\n1. Park Vehicle\n2. Remove Vehicle\n3. View Parking Status\n4. Exit");
            System.out.print("Choose your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter vehice ID: ");
                    int parkingVID = sc.nextInt();
                    System.out.println("Enter parking vehicle type: ");
                    sc.nextLine();
                    String parkingVType = sc.nextLine();
                    ps.park(parkingVID,parkingVType);
                    break;

                case "2":
                    System.out.println("Enter vehice ID: ");
                    int removeVID = sc.nextInt();
                    sc.nextLine();
                    ps.removeVehicle(removeVID);
                    break;
                
                case "3":
                    System.out.println("Parking Status:");
                    ps.viewParkingStatus();
                    break;
                
                case "4":
                    System.out.println("Thank You!");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}
