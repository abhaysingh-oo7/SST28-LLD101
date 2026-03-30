class Seat {
    private String seatId;
    private int row;
    private int number;
    private SeatType type;
    private SeatStatus status;

    public Seat(String seatId, int row, int number, SeatType type) {
        this.seatId = seatId;
        this.row = row;
        this.number = number;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public SeatType getType() {
        return type;
    }

    public void bookSeat() {
        this.status = SeatStatus.BOOKED;
    }

    // public void blockSeat() {
    // this.status = SeatStatus.BLOCKED;
    // }

    public void releaseSeat() {
        this.status = SeatStatus.AVAILABLE;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

}