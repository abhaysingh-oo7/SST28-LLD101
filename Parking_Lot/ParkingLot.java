package Parking_Lot;
import java.util.*;

class ParkingLot {
    List<Floor> floors;
    Map<String, ParkingTicket> activeTickets;
    int ticketCounter = 0;

    ParkingLot(List<Floor> floors) {
        this.floors = floors;
        this.activeTickets = new HashMap<>();
    }

    ParkingTicket parkVehicle(Vehicle vehicle, EntryGate gate) {
        SlotType requiredType = getSlotType(vehicle.type);

        ParkingSlot bestSlot = null;
        int minDistance = Integer.MAX_VALUE;

        for (Floor floor : floors) {
            ParkingSlot slot = floor.findNearestAvailableSlot(requiredType, gate.gateId);

            if (slot != null) {
                int distance = slot.distanceFromGateMap.get(gate.gateId);

                if(distance < minDistance){
                    minDistance = distance;
                    bestSlot = slot;
                }

            }
        }

        if (bestSlot == null) {
            System.out.println("No slot available");
            return null;
        }

        bestSlot.assign(); // to prevent duplicate assignment

        String ticketId = "T" + (++ticketCounter);
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, bestSlot, gate.gateId);

        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    double generateBill(String ticketId, long exitTime) {
        ParkingTicket ticket = activeTickets.get(ticketId);

        long duration = exitTime - ticket.entryTime;
        double amount = calculateAmount(ticket.slot.type, duration);

        // freeing the slot 

        ticket.slot.free(); 
        activeTickets.remove(ticketId);

        return amount;
    }

    void showStatus() {
        for (Floor floor : floors) {
            System.out.println("Floor " + floor.floorNumber);

            for (ParkingSlot slot : floor.slots) {
                System.out.println(slot.slotId + " : " + slot.status);
            }
        }
    }

    private SlotType getSlotType(VehicleType type) {
        return SlotType.valueOf(type.name());
    }

    private double calculateAmount(SlotType type, long durationMillis) {
        double hours = durationMillis / (1000.0 * 60 * 60);

        switch (type) {
            case SMALL: return hours * 10;
            case MEDIUM: return hours * 20;
            case LARGE: return hours * 30;
        }
        return 0;
    }
}
