package Parking_Lot;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        EntryGate gate1 = new EntryGate("G1");
        EntryGate gate2 = new EntryGate("G2");

        // -----------------Floor 1----------------
        List<ParkingSlot> floor1Slots = new ArrayList<>();

        // slot F1-S1
        Map<String, Integer> f1s1Map = new HashMap<>();
        f1s1Map.put("G1", 10);
        f1s1Map.put("G2", 20);
        floor1Slots.add(new ParkingSlot("F1-S1", SlotType.SMALL, f1s1Map));

        // Slot F1-S2
        Map<String, Integer> f1s2Map = new HashMap<>();
        f1s2Map.put("G1", 15);
        f1s2Map.put("G2", 5);
        floor1Slots.add(new ParkingSlot("F1-S2", SlotType.MEDIUM, f1s2Map));

        // Slot F1-S3
        Map<String, Integer> f1s3Map = new HashMap<>();
        f1s3Map.put("G1", 25);
        f1s3Map.put("G2", 10);

        Floor floor1 = new Floor(1, floor1Slots);

        // ---------------- FLOOR 2 ----------------

        List<ParkingSlot> floor2Slots = new ArrayList<>();

        // Slot F2-S1
        Map<String, Integer> f2s1Map = new HashMap<>();
        f2s1Map.put("G1", 5);
        f2s1Map.put("G2", 15);
        floor2Slots.add(new ParkingSlot("F2-S1", SlotType.SMALL, f2s1Map));

        // Slot F2-S2
        Map<String, Integer> f2s2Map = new HashMap<>();
        f2s2Map.put("G1", 12);
        f2s2Map.put("G2", 8);
        floor2Slots.add(new ParkingSlot("F2-S2", SlotType.MEDIUM, f2s2Map));

        // Slot F2-S3
        Map<String, Integer> f2s3Map = new HashMap<>();
        f2s3Map.put("G1", 20);
        f2s3Map.put("G2", 6);
        floor2Slots.add(new ParkingSlot("F2-S3", SlotType.LARGE, f2s3Map));

        Floor floor2 = new Floor(2, floor2Slots);

        // Create Parking Lot
        List<Floor> floors = Arrays.asList(floor1, floor2);
        ParkingLot parkingLot = new ParkingLot(floors);

        // Vehicles
        Vehicle v1 = new Vehicle("MH12AB1234", VehicleType.SMALL);
        Vehicle v2 = new Vehicle("MH12CD5678", VehicleType.MEDIUM);
        Vehicle v3 = new Vehicle("MH12EF9999", VehicleType.LARGE);

        // Park Vehicles

        //Park from Gate G1
        System.out.println("\n--- Parking from Gate G1 ---");
        ParkingTicket t1 = parkingLot.parkVehicle(v1, gate1);
        System.out.println("Ticket: " + t1.ticketId + " Slot: " + t1.slot.slotId);

        ParkingTicket t2 = parkingLot.parkVehicle(v2, gate1);
        System.out.println("Ticket: " + t2.ticketId + " Slot: " + t2.slot.slotId);

        //Park from Gate G2
        System.out.println("\n--- Parking from Gate G2 ---");
        ParkingTicket t3 = parkingLot.parkVehicle(v3, gate2);
        System.out.println("Ticket: " + t3.ticketId + " Slot: " + t3.slot.slotId);

        //Show Status
        System.out.println("\n--- Parking Status ---");
        parkingLot.showStatus();

        //Simulate delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Generate Bill
        double bill = parkingLot.generateBill(t1.ticketId, System.currentTimeMillis());
        System.out.println("\nBill for " + t1.ticketId + " = Rs " + bill);

        //Final Status
        System.out.println("\n--- Final Status ---");
        parkingLot.showStatus();
    }
}