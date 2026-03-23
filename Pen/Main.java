public class Main {
    public static void main(String[] args) {
        
        OpenCloseStrategy clickStrategy = new ClickOpenCloseStrategy();
        OpenCloseStrategy capStrategy = new CapOpenCloseStrategy();

        RefillStrategy cartridgeStrategy = new CartridgeRefillStrategy();
        RefillStrategy inkStrategy = new InkRefillStrategy();

        Pen gelPen = new GellPen("Red", 100, clickStrategy, cartridgeStrategy);
        Pen ballPen = new BallPen("blue", 100, capStrategy, cartridgeStrategy);
        Pen fountainPen = new FountainPen("purple", 100, capStrategy, inkStrategy);


        System.out.println("gell pen --");
        gelPen.write("Hello");
        gelPen.open();
        gelPen.write("Hello gel");
        System.out.println(gelPen.refillPercent);
        gelPen.refill("green");

        System.out.println("********************************************");

        System.out.println("ball pen --");
        ballPen.write("Hello");
        ballPen.open();
        ballPen.write("Hello from ball");
        System.out.println(ballPen.refillPercent);
        ballPen.refill("yellow");

        System.out.println("********************************************");

        System.out.println("fountain pen --");
        fountainPen.write("Hello");
        fountainPen.open();
        fountainPen.write("Hello from fountain");
        System.out.println(fountainPen.refillPercent);
        fountainPen.refill("maroon");

            
        

    }
}
