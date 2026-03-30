import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Setup (same as before)
        User user1 = new User("U1", "Abhay", "abhay@gmail.com");
        User user2 = new User("U2", "Rahul", "rahul@gmail.com");

        Movie movie = new Movie("M1", "Inception", 150, "English");

        City city = new City("C1", "Mumbai");
        Theater theater = new Theater("T1", "PVR", city);
        city.addTheater(theater);

        Screen screen = new Screen("S1", "Screen 1");
        theater.addScreen(screen);

        List<Seat> allSeats = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Seat seat = new Seat("A" + i, 1, i, SeatType.GOLD);
            screen.addSeat(seat);
            allSeats.add(seat);
        }

        Show show = new Show(
                "SH1",
                movie,
                screen,
                new Date(),
                new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)
        );

        BookingService bookingService = new BookingService();

        // -------------------------------
        // TEST 1: Successful Booking
        // -------------------------------
        System.out.println("\nTEST 1: Successful Booking");

        List<Seat> seats1 = Arrays.asList(allSeats.get(0), allSeats.get(1));
        Payment payment1 = new UpiPayment("user1@upi");

        Booking booking1 = bookingService.createBooking(
                user1, show, seats1, payment1, 300
        );

        if (booking1 != null) {
            System.out.println("Booking1 Status: " + booking1.getStatus());
        }

        // -------------------------------
        // TEST 2: Double Booking Same Seat
        // -------------------------------
        System.out.println("\nTEST 2: Double Booking Attempt");

        List<Seat> seats2 = Arrays.asList(allSeats.get(0)); // already booked
        Payment payment2 = new CreditCardPayment("1234");

        Booking booking2 = bookingService.createBooking(
                user2, show, seats2, payment2, 150
        );

        if (booking2 == null) {
            System.out.println("Booking2 failed as expected (seat already booked)");
        }

        // -------------------------------
        // TEST 3: Payment Failure
        // -------------------------------
        System.out.println("\nTEST 3: Payment Failure");

        Payment failedPayment = new Payment() {
            @Override
            public boolean pay(double amount) {
                System.out.println("Payment failed intentionally");
                return false;
            }
        };

        List<Seat> seats3 = Arrays.asList(allSeats.get(2));

        Booking booking3 = bookingService.createBooking(
                user2, show, seats3, failedPayment, 150
        );

        System.out.println("Booking3 Status: " + booking3.getStatus());

        // -------------------------------
        // TEST 4: Cancel Non-Confirmed Booking
        // -------------------------------
        System.out.println("\nTEST 4: Cancel Failed Booking");

        bookingService.cancelBooking(booking3);

        // -------------------------------
        // TEST 5: Cancel Confirmed Booking
        // -------------------------------
        System.out.println("\nTEST 5: Cancel Confirmed Booking");

        bookingService.cancelBooking(booking1);
        System.out.println("Booking1 Final Status: " + booking1.getStatus());
    }
}