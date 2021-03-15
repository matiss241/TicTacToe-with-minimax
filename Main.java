import java.util.Scanner;

public class Main {

    // Tic tac toe grid consists of array of type Move that contains move's value(X/O) and position on the grid
    private static Move[][] grid = new Move[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Chose a computer level to play against 1/2/3 or chose 4 to enter two player mode");
        if(sc.hasNextInt()){
            int choice = sc.nextInt();
            if(choice >= 1 && choice <=4){
                switch (choice){
                    case 1:
                        gameMode1();
                        break;
                    case 2:
                        gameMode2();
                        break;
                    case 3:
                        gameMode3();
                        break;
                    case 4:
                        gameMode4();
                        break;
                }
            }else{
                System.out.println("Input error");
            }
        } else{
            System.out.println("Input error");
        }
    }

    public static Move[][] getGrid() {
        return grid;
    }

    // StartUp method fills the array with blank values and sets their positions on the grid
    public static void startUp() {
        int count = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[j][i] = new Move(" ", count);
                count++;
            }
        }
    }

    // IsEmpty method checks if the positions to which the move is being made is empty
    public static boolean isEmpty(int position) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i].getPosition() == position && grid[j][i].getSymbol() == " ") {
                    return true;
                }
            }
        }
        return false;
    }

    public static void putMove(Move move) {
        int position = move.getPosition();
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (count == position) {
                    grid[j][i] = move;
                }
                count++;
            }
        }
    }

    public static boolean gameOver() {
        boolean isOver = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[j][i].getSymbol().equals(" ")) {
                    isOver = false;
                }
            }
        }
        return isOver;
    }

    // Checks if anyone has won
    public static String hasWon() {
        String combination = "";
        for (int i = 1; i <= 8; i++) {
            switch (i) {
                case 1:
                    combination = grid[0][0].getSymbol() + grid[1][0].getSymbol() + grid[2][0].getSymbol();
                    break;
                case 2:
                    combination = grid[0][1].getSymbol() + grid[1][1].getSymbol() + grid[2][1].getSymbol();
                    break;
                case 3:
                    combination = grid[0][2].getSymbol() + grid[1][2].getSymbol() + grid[2][2].getSymbol();
                    break;
                case 4:
                    combination = grid[0][0].getSymbol() + grid[0][1].getSymbol() + grid[0][2].getSymbol();
                    break;
                case 5:
                    combination = grid[1][0].getSymbol() + grid[1][1].getSymbol() + grid[1][2].getSymbol();
                    break;
                case 6:
                    combination = grid[2][0].getSymbol() + grid[2][1].getSymbol() + grid[2][2].getSymbol();
                    break;
                case 7:
                    combination = grid[0][0].getSymbol() + grid[1][1].getSymbol() + grid[2][2].getSymbol();
                    break;
                case 8:
                    combination = grid[2][0].getSymbol() + grid[1][1].getSymbol() + grid[0][2].getSymbol();
                    break;
            }
            if (combination.equals("XXX")) {
                return "X";
            } else if (combination.equals("OOO")) {
                return "O";
            }
        }
        return " ";
    }

    // Prints the grid with made moves
    private static void printTheGrid() {
        System.out.println("   |   |   ");
        System.out.println(" " + grid[0][0].getSymbol() + " | " + grid[1][0].getSymbol() + " | " + grid[2][0].getSymbol() + " ");
        System.out.println("   |   |   ");
        System.out.println("-----------");
        System.out.println("   |   |   ");
        System.out.println(" " + grid[0][1].getSymbol() + " | " + grid[1][1].getSymbol() + " | " + grid[2][1].getSymbol() + " ");
        System.out.println("   |   |   ");
        System.out.println("-----------");
        System.out.println("   |   |   ");
        System.out.println(" " + grid[0][2].getSymbol() + " | " + grid[1][2].getSymbol() + " | " + grid[2][2].getSymbol() + " ");
        System.out.println("   |   |   ");
        System.out.println("********************************");
    }

    private static void printTheRules() {
        System.out.println("You are playing tic tac toe");
        System.out.println("To make a move you have to enter your move's position on the grid");
        System.out.println("Possible moves:");
        System.out.println("1 2 3\n4 5 6\n7 8 9");
    }


    private static void gameMode1(){
        Player player = new Player();
        Computer1 computer = new Computer1();

        printTheRules();
        startUp();
        printTheGrid();

        while (!gameOver() || hasWon().equals(" ")) {
            Move playersMove = player.makeMove(1);
            putMove(playersMove);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
            Move computersMove = computer.computerMove();
            putMove(computersMove);
            printTheGrid();
        }
        if(hasWon().equals(" ")){
            System.out.println("It is a draw!");
        }else {
            System.out.println(hasWon() + " has won!");
        }
    }

    private static void gameMode2(){
        Player player = new Player();
        Computer2 computer = new Computer2();

        printTheRules();
        startUp();
        printTheGrid();

        while (!gameOver() || hasWon().equals(" ")) {
            Move playersMove = player.makeMove(1);
            putMove(playersMove);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
            Move computersMove = computer.computerMove();
            putMove(computersMove);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
        }
        if(hasWon().equals(" ")){
            System.out.println("It is a draw!");
        }else {
            System.out.println(hasWon() + " has won!");
        }
    }

    private static void gameMode3(){
        Player player = new Player();
        Computer3 ai = new Computer3();

        printTheRules();
        startUp();
        printTheGrid();

        while (!gameOver() || hasWon().equals(" ")) {
            Move playersMove = player.makeMove(1);
            putMove(playersMove);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
            Move aiMove =ai.findBestMove();
            putMove(aiMove);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
        }
        if(hasWon().equals(" ")){
            System.out.println("It is a draw!");
        }else {
            System.out.println(hasWon() + " has won!");
        }
    }

    private static void gameMode4(){
        Player player1 = new Player();
        Player player2 = new Player();

        printTheRules();
        startUp();
        printTheGrid();

        while (!gameOver() || hasWon().equals(" ")) {
            Move playersMove1 = player1.makeMove(1);
            putMove(playersMove1);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
            Move playersMove2 = player2.makeMove(2);
            putMove(playersMove2);
            printTheGrid();
            if(gameOver() || hasWon() != " "){
                break;
            }
        }
        if(hasWon().equals(" ")){
            System.out.println("It is a draw!");
        }else {
            System.out.println(hasWon() + " has won!");
        }
    }
}
