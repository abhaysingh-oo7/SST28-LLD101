public class CartridgeRefillStrategy implements RefillStrategy{
    public void refill(Pen pen, String color){
        pen.refillPercent = 100;
        System.out.println("Cartridge replaced with" +color+"ink");
    }
}
