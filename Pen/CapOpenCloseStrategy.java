class CapOpenCloseStrategy implements OpenCloseStrategy {

    @Override
    public void open(Pen pen) {
        pen.isOpen = true;
        System.out.println("Cap removed");
    }

    @Override
    public void close(Pen pen) {
        pen.isOpen = false;
        System.out.println("Cap closed");
    }
}