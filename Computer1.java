import java.util.Random;

// Level 1 computer randomly picks a move from the available moves in the grid
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
