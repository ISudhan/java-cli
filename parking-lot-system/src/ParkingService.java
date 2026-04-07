public class ParkingService {
    ParkingSlot pSlot;
    ParkingService(ParkingSlot pSlot){
        this.pSlot = pSlot;
    }
    public void park(int parkingVID,String parkingVType){
        Vehicle newVehicle = new Vehicle(parkingVID, parkingVType);
        if(!isAvailable(parkingVID)){
            for(int i=0;i<pSlot.slots.length;i++){
                if(pSlot.slots[i] == null){
                    pSlot.slots[i] = newVehicle;
                    System.out.println("Vehicle Parked Successfully");
                    return;
                }
            }
            System.out.println("Parking Slot if FULL");
        }
        else{
            System.out.println("Vehicle is already parked");
        }
    }

    public boolean isAvailable(int vID){
        for(int i=0;i<pSlot.slots.length;i++){
            if(pSlot.slots[i] != null && pSlot.slots[i].id == vID) return true;
        }
        return false;
    }

    public void viewParkingStatus(){
        for(int i=0;i<pSlot.slots.length;i++){
            if(pSlot.slots[i] != null){
                System.out.println("Slot-"+(i+1)+" "+pSlot.slots[i].id+" "+pSlot.slots[i].type);    
            }
            else{
                System.out.println("Slot-"+(i+1)+" Empty");
            }
        }
    }

    public void removeVehicle(int rID){
        if(isAvailable(rID)){
            for(int i=0;i<pSlot.slots.length;i++){
                if(pSlot.slots[i].id == rID){
                    pSlot.slots[i] = null;
                    System.out.println("Vehicle removed Successfully");
                    return;
                }
            }
        }
        else{
            System.out.println("Vehicle is not in the Parking slot");
        }
    }
}
