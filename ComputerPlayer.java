 

import java.util.*;
/**
 * Represents a computer-controlled player. 
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer(TicTacToeBoard board, char mark) {
        /** Pass board and mark to the parent class constructor. */
        super(board,mark);
    }
    
    /**
     * Retrieves the name associated with this Player.
     * @return Name of the Player.
     */
    @Override
    public String getName() {
        return "Computer";
    }
    
    /**
     * Attempts a move. The computer will choose random spots on the board
     * until one of them succeeds. 
     * @return True if the move results in a finished game.
     */
    @Override
    public boolean makeMove() {
        boolean turnDone = false;
        boolean gameOver = false;
        System.out.println("\nComputer's move: ");
         
        while (!turnDone) {
            /** 
             * Generate random row and col values related to the 
             * dimensions of the board grid. The computer will continue making
             * random moves until one of them succeeds.
             */
            int row = new Random().nextInt(3);
            int col = new Random().nextInt(3);
            try {
                /** Fix any errors in the lines below. */
                turnDone = board.move(row,col,mark);
                turnDone = true;
                if((board.isWin(mark) == true) || (board.isTie() == true)){
                    gameOver = true;
                }
                else gameOver = false;
                return gameOver;
            } catch (IllegalMoveException e) {
                // Display nothing. If the move was illegal, the computer
                // will try again.
            }
        }
        return gameOver;
    }
}
