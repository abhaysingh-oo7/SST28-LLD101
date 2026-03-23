abstract class Pen {
    String color;
    boolean isOpen;
    int refillPercent;

    OpenCloseStrategy openCloseStrategy;
    RefillStrategy refillStrategy;

    Pen(String color, int refillPercent, OpenCloseStrategy openCloseStrategy, RefillStrategy refillStrategy) {

        this.color = color;
        this.refillPercent = refillPercent;
        this.isOpen = false;
        this.openCloseStrategy = openCloseStrategy;
        this.refillStrategy = refillStrategy;
    }

    void open() {
        openCloseStrategy.open(this);
    }

    void close() {
        openCloseStrategy.close(this);
    }

    public final void write(String text) {
        if (!isOpen) {
            System.out.println("Cannot write: Pen is closed");
            return;
        }

        if (refillPercent <= 0) {
            System.out.println("Cannot write: No ink left");
            return;
        }

        writeInternal(text); // subclass-specific behavior

        decreaseRefill(text); // common logic
    }
    protected void decreaseRefill(String text) {
        refillPercent -= text.length();
    }

    protected abstract void writeInternal(String text);

    void refill(String color) {
        refillStrategy.refill(this, color);
    }
}