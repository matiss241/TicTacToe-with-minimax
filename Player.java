import java.util.Scanner;

public class Player {

    public Move makeMove(int player) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your move: ");
        if (sc.hasNextInt()) {

            int move = sc.nextInt();
            if (move >= 1 && move <= 9) {
                if (Main.isEmpty(move)) {
                    return new Move(((player == 1)?"X":"O"), move);
                } else {
                    System.out.println("You can't make this move");
                    return makeMove(player);
                }
            } else {
                System.out.println("Invalid position chosen");
                return makeMove(player);
            }
        } else {
            System.out.println("You had to enter a whole number form 1 to 9");
            return makeMove(player);
        }
    }
}
