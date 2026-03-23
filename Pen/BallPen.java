class BallPen extends Pen {

    public BallPen(String color, int refillPercent, OpenCloseStrategy ocStrategy, RefillStrategy refillStrategy) {
        super(color, refillPercent, ocStrategy, refillStrategy);
    }

    @Override
    public void writeInternal(String text) {
        // if (!isOpen) {
            // System.out.println("open the pen to write");
            // return;
        // }
        System.out.println("Written by ball pen: " + text);
        // refillPercent -= text.length();
    }
}