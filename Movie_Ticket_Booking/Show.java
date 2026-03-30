import java.util.*;

class Show {
    private String showId;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private Date endTime;
    private List<Seat> seats;

    public Show(String showId, Movie movie, Screen screen, Date startTime, Date endTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = new ArrayList<>(screen.getSeats()); // snapshot of seats
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> available = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.getStatus() == SeatStatus.AVAILABLE) {
                available.add(seat);
            }
        }
        return available;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}