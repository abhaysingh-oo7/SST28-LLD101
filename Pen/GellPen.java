public class GellPen extends Pen {
    
    public GellPen(String color, int refillPercent, OpenCloseStrategy ocStrategy, RefillStrategy refillStrategy){
        super(color, refillPercent, ocStrategy, refillStrategy);
    }

    public void writeInternal(String text){
        // if(!isOpen){
            // System.out.println("open the pen to write");
            // return;
        // }
        System.out.println("written by gel pen" + text);
        // refillPercent -= text.length();
    }
}
