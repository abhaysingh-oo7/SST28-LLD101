class ClickOpenCloseStrategy implements OpenCloseStrategy {

    @Override
    public void open(Pen pen) {
        pen.isOpen = true;
        System.out.println("Pen clicked open");
    }

    @Override
    public void close(Pen pen) {
        pen.isOpen = false;
        System.out.println("Pen clicked closed");
    }
}