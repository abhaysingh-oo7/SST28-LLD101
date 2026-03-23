package Snake_Ladder;

public class easyLevel implements Level {
    
    
    // can return any number of sixes simultaneously;
    @Override
    public void move(Player p, int boundry) {

        int n = Dice.roll();

        while(n == 6){
            System.out.println(p.name +" got: "+ n);
            if(p.currPosition+6 <=boundry){
                p.currPosition +=  6;
                System.out.println("new position of:"+p.name+" : "+p.currPosition);        
            }
            else break;
            n = Dice.roll();
        }

        if(p.currPosition+n <= boundry){
            System.out.println(p.name +" got: "+ n);
            p.currPosition +=  n;
            System.out.println("new position of:"+p.name+" : "+p.currPosition);        
        }
    }
}
