import java.util.Random;

public class Computer1 {

    public Move computerMove() {
        if(!Main.gameOver() && Main.hasWon().equals(" ")){
            int move = new Random().nextInt(9) + 1;
            if (Main.isEmpty(move)) {
                return new Move("O", move);
            } else {
                return computerMove();
            }
        }
        return null;
    }
}
