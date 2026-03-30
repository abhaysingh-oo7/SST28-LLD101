import java.util.*;

class SeatLockService {

    private Map<String, SeatLock> lockedSeats = new HashMap<>();

    // Lock seats
    public boolean lockSeats(List<Seat> seats, String userId) {

        for (Seat seat : seats) {

            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                return false;
            }

            // Check if already locked
            if (lockedSeats.containsKey(seat.getSeatId())) {
                SeatLock lock = lockedSeats.get(seat.getSeatId());

                if (!lock.isLockExpired()) {
                    return false;
                }
            }
        }

        // Lock all seats
        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.LOCKED);
            lockedSeats.put(seat.getSeatId(), new SeatLock(seat, userId));
        }

        return true;
    }

    // Unlock seats
    public void unlockSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.AVAILABLE);
            lockedSeats.remove(seat.getSeatId());
        }
    }

    // Validate lock ownership
    public boolean validateLock(List<Seat> seats, String userId) {
        for (Seat seat : seats) {
            SeatLock lock = lockedSeats.get(seat.getSeatId());

            if (lock == null || !lock.getUserId().equals(userId)) {
                return false;
            }
        }
        return true;
    }
}