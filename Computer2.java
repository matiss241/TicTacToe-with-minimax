import java.util.Random;

public class Computer2 {

    public Move computerMove() {
        if(!Main.gameOver() && Main.hasWon().equals(" ")){
            int cw = canWin();
            if(cw > 0){
                return new Move("O", cw);
            }
            int move = new Random().nextInt(9) + 1;
            if (Main.isEmpty(move)) {
                return new Move("O", move);
            } else {
                return computerMove();
            }
        }
        return null;
    }

    public int canWin(){
        for(int i=0; i<9; i++){
            if(Main.isEmpty(i)){
                Main.putMove(new Move("O", i));
                if(!Main.hasWon().equals(" ")){
                    Main.putMove(new Move(" ", i));
                    return i;
                }
                Main.putMove(new Move(" ", i));
            }
        }
        return -1;
    }
}
