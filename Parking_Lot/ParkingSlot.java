package Parking_Lot;
import java.util.*;

class ParkingSlot {
    String slotId;
    SlotType type;
    SlotStatus status;
    Map<String, Integer> distanceFromGateMap;

    ParkingSlot(String id, SlotType type, Map<String, Integer> distanceMap) {
        this.slotId = id;
        this.type = type;
        this.status = SlotStatus.AVAILABLE;
        this.distanceFromGateMap = distanceMap;
    }

    boolean isAvailable() {
        return status == SlotStatus.AVAILABLE;
    }

    void assign() {
        status = SlotStatus.OCCUPIED;
    }

    void free() {
        status = SlotStatus.AVAILABLE;
    }
}
