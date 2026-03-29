package Parking_Lot;
import java.util.*;

class Floor {
    int floorNumber;
    List<ParkingSlot> slots;

    Floor(int number, List<ParkingSlot> slots) {
        this.floorNumber = number;
        this.slots = slots;
    }

    ParkingSlot findNearestAvailableSlot(SlotType type, String gateId) {
        ParkingSlot best = null;
        int minDistance = Integer.MAX_VALUE;

        for (ParkingSlot slot : slots) {
            if (slot.type == type && slot.isAvailable()) {
                int distance = slot.distanceFromGateMap.get(gateId);
                if (distance < minDistance) {
                    minDistance = distance;
                    best = slot;
                }
            }
        }
        return best;
    }
}
