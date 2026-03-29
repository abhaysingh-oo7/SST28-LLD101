package Parking_Lot;

class ParkingTicket {
    String ticketId;
    Vehicle vehicle;
    long entryTime;
    ParkingSlot slot;
    String entryGateId;

    ParkingTicket(String id, Vehicle vehicle, ParkingSlot slot, String gateId) {
        this.ticketId = id;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = System.currentTimeMillis();
        this.entryGateId = gateId;
    }
}