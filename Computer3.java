import jdk.swing.interop.SwingInterOpUtils;

public class Computer3 {
    class AiMove {
        int row, col;
    };

    static String opponent = "X", player = "O";

    public int evaluate(){
        if(Main.hasWon().equals(player)){
            return 10;
        } else if(Main.hasWon().equals(opponent)){
            return -10;
        }else {
            return 0;
        }
    }

    public int minimax(int depth, boolean isMax) {
        int score = evaluate();

        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }

        if (Main.gameOver()) {
            return 0;
        }

        if (isMax) {
            int best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Main.isEmpty(getPosition(j,i))) {
                        Main.putMove(new Move(player, getPosition(j, i)));
                        best = Math.max(best, minimax(depth - 1, false));
                        Main.putMove(new Move(" ", getPosition(j, i)));
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Main.isEmpty(getPosition(j,i))) {
                        Main.putMove(new Move(opponent, getPosition(j, i)));
                        best = Math.min(best, minimax(depth - 1, true));
                        Main.putMove(new Move(" ", getPosition(j, i)));
                    }
                }
            }
            return best;
        }
    }

    public Move findBestMove() {
        int bestVal = -1000;
        AiMove bestMove = new AiMove();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Main.isEmpty(getPosition(j,i))) {
                    Main.putMove(new Move(player, getPosition(j, i)));
                    int moveVal = minimax(6, false);
                    Main.putMove(new Move(" ", getPosition(j, i)));
                    if (moveVal > bestVal) {
                        bestMove.row = j;
                        bestMove.col = i;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return getPosition(bestMove);
    }

    public Move getPosition(AiMove bestMove){
        int count = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(bestMove.row == j && bestMove.col == i){
                    return new Move(player, count+1);
                }
                count++;
            }
        }
        return null;
    }

    public int getPosition(int bj, int bi){
        int count = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(bi == i && bj == j){
                    return count+1;
                }
                count++;
            }
        }
        return -1;
    }
}
