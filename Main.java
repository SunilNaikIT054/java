import java.util.Scanner;

interface ParkingOperations {
    void parkVehicle(String vehicleDetails);
    void removeVehicle(String spotID);
    void viewParkedVehicles();
    boolean checkAvailability();
}

abstract class ParkingSpot {
    String spotID;
    boolean isOccupied;
    String vehicleDetails;

    public ParkingSpot(String spotID) {
        this.spotID = spotID;
        this.isOccupied = false;
        this.vehicleDetails = "";
    }
}

class ParkingLot extends ParkingSpot implements ParkingOperations {
    private ParkingSpot[] spots;

    public ParkingLot(int size) {
        super("");  // Placeholder, not used in this context
        spots = new ParkingSpot[size];
        for (int i = 0; i < size; i++) {
            spots[i] = new ParkingSpot("Spot" + (i + 1)) {};
        }
    }

    @Override
    public void parkVehicle(String vehicleDetails) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied) {
                spot.isOccupied = true;
                spot.vehicleDetails = vehicleDetails;
                System.out.println("Vehicle parked at " + spot.spotID);
                return;
            }
        }
        System.out.println("No available spots.");
    }

    @Override
    public void removeVehicle(String spotID) {
        for (ParkingSpot spot : spots) {
            if (spot.spotID.equals(spotID) && spot.isOccupied) {
                System.out.println("Vehicle " + spot.vehicleDetails + " removed from " + spotID);
                spot.isOccupied = false;
                spot.vehicleDetails = "";
                return;
            }
        }
        System.out.println("No vehicle found at " + spotID);
    }

    @Override
    public void viewParkedVehicles() {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied) {
                System.out.println(spot.spotID + ": " + spot.vehicleDetails);
            }
        }
    }

    @Override
    public boolean checkAvailability() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot(5);
        
        while (true) {
            System.out.println("\nParking Lot Management System:");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Check Availability");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle details: ");
                    String vehicleDetails = scanner.nextLine();
                    parkingLot.parkVehicle(vehicleDetails);
                    break;
                case 2:
                    System.out.print("Enter spot ID to remove vehicle: ");
                    String spotID = scanner.nextLine();
                    parkingLot.removeVehicle(spotID);
                    break;
                case 3:
                    parkingLot.viewParkedVehicles();
                    break;
                case 4:
                    System.out.println("Availability: " + (parkingLot.checkAvailability() ? "Yes" : "No"));
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}