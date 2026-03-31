package Movie_Ticket_Booking;

import java.util.List;
import java.util.UUID;

class BookingService {

    private SeatLockService seatLockService = new SeatLockService();

    public Booking createBooking(User user, Show show,
            List<Seat> seats,
            Payment payment,
            double amount) {

        // 1. Lock seats first
        boolean locked = seatLockService.lockSeats(seats, user.getUserId());

        if (!locked) {
            System.out.println("Seats already locked!");
            return null;
        }

        // 2. Create booking
        Booking booking = new Booking(
                UUID.randomUUID().toString(),
                user,
                show,
                seats,
                payment,
                amount);

        // 3. Process payment
        boolean success = payment.pay(amount);

        if (!success) {
            seatLockService.unlockSeats(seats);
            booking.setStatus(BookingStatus.FAILED);
            return booking;
        }

        // 4. Confirm booking
        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.BOOKED);
        }

        booking.setStatus(BookingStatus.CONFIRMED);

        return booking;
    }

    public void cancelBooking(Booking booking) {

        if (booking == null) {
            System.out.println("Invalid booking");
            return;
        }

        if (booking.getStatus() != BookingStatus.CONFIRMED) {
            System.out.println("Cannot cancel booking. Status: " + booking.getStatus());
            return;
        }

        for (Seat seat : booking.getBookedSeats()) {
            seat.releaseSeat();
        }

        booking.setStatus(BookingStatus.CANCELLED);

        // Refund
        Refund refund = new Refund(
                "R-" + booking.getBookingId(),
                booking.getAmount());

        refund.initiateRefund();

        System.out.println("Booking cancelled & refund processed");
    }
}