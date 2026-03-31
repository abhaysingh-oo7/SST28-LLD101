package Movie_Ticket_Booking;
import java.util.List;

class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private List<Seat> bookedSeats;
    private BookingStatus status;
    private Payment payment;
    private double amount;

    public Booking(String bookingId, User user, Show show,
            List<Seat> seats, Payment payment, double amount) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.bookedSeats = seats;
        this.payment = payment;
        this.amount = amount;
        this.status = BookingStatus.FAILED;
    }

    public Payment getPayment() {
        return payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public String getBookingId() {
        return bookingId;
    }

    
}