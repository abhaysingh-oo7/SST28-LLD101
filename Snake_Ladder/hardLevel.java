package Snake_Ladder;

public class hardLevel implements Level{
    // can return 3 sixes simultaneously ;
    @Override
    public void move(Player p, int boundry) {
        int count = 0;
        int n = Dice.roll();

        while(n == 6 && count < 3){
            
            count ++;

            if(p.currPosition+6 <= boundry){
                p.currPosition +=  6;
                System.out.println("new position of:"+p.name+" : "+p.currPosition);
            }
            if (count == 3) {
                System.out.println(p.name + " rolled 3 sixes turn skipped");
                return;
            }

            n = Dice.roll();
        }

        if(p.currPosition+n <= boundry){
            p.currPosition +=  n;
            System.out.println("new position of:"+p.name+" : "+p.currPosition);

        }

    }

}
