class FountainPen extends Pen {

    public FountainPen(String color, int refillPercent, OpenCloseStrategy ocStrategy, RefillStrategy refillStrategy) {
        super(color, refillPercent, ocStrategy, refillStrategy);
    }

    @Override
    protected void writeInternal(String text) {
        // if (!isOpen) {
            // System.out.println("Open the pen first!");
            // return;
        // }
        System.out.println("Written by fountain pen: " + text);
        // refillPercent -= text.length() * 2; // consumes more ink
    }
    protected void decreaseRefill(String text){
        refillPercent -= text.length() * 2;
    }

}