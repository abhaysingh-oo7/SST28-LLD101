import java.util.Date;

class SeatLock {
    private Seat seat;
    private String userId;
    private Date lockTime;
    private int timeoutInSeconds = 300; 

    public SeatLock(Seat seat, String userId) {
        this.seat = seat;
        this.userId = userId;
        this.lockTime = new Date();
    }

    public boolean isLockExpired() {
        long currentTime = new Date().getTime();
        long lockCreatedTime = lockTime.getTime();

        return (currentTime - lockCreatedTime) > timeoutInSeconds * 1000;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getUserId() {
        return userId;
    }
}