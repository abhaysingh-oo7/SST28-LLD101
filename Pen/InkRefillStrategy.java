public class InkRefillStrategy implements RefillStrategy {

    @Override
    public void refill(Pen pen, String color) {
        if (pen.refillPercent >= 100) {
            System.out.println("Ink already full, but refilling anyway...");
        }
        pen.refillPercent = 100;
        System.out.println("Fountain pen refilled with "+ color+ "ink");
    }
}