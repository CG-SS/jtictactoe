package jtictactoe.logic;

import javax.swing.JButton;
import jtictactoe.resources.ImageCache;

/**
 *
 * @author CGSS
 */
public class LogicHelper {

    public enum WINNER {
        NOBODY, X, O
    }

    private LogicHelper() {
    }

    public static WINNER isWinningState(final JButton[][] buttonMatrix) {
        WINNER winner;
        winner = checkHorizontally(buttonMatrix);
        if(winner != WINNER.NOBODY){
            return winner;
        }
        winner = checkDiagonals(buttonMatrix);
        if(winner != WINNER.NOBODY){
            return winner;
        }
        
        return checkVertically(buttonMatrix);
    }
    
    private static WINNER checkDiagonals(final JButton[][] buttonMatrix){
        if(
                buttonMatrix[0][0].getIcon() == ImageCache.TICTACTOE_O.getImageIcon() &&
                buttonMatrix[1][1].getIcon() == ImageCache.TICTACTOE_O.getImageIcon() &&
                buttonMatrix[2][2].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                ) {
            return WINNER.O;
        }
        if(
                buttonMatrix[0][0].getIcon() == ImageCache.TICTACTOE_X.getImageIcon() &&
                buttonMatrix[1][1].getIcon() == ImageCache.TICTACTOE_X.getImageIcon() &&
                buttonMatrix[2][2].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                ) {
            return WINNER.X;
        }
        if(
                buttonMatrix[0][2].getIcon() == ImageCache.TICTACTOE_O.getImageIcon() &&
                buttonMatrix[1][1].getIcon() == ImageCache.TICTACTOE_O.getImageIcon() &&
                buttonMatrix[2][0].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                ) {
            return WINNER.O;
        }
        if(
                buttonMatrix[0][2].getIcon() == ImageCache.TICTACTOE_X.getImageIcon() &&
                buttonMatrix[1][1].getIcon() == ImageCache.TICTACTOE_X.getImageIcon() &&
                buttonMatrix[2][0].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                ) {
            return WINNER.X;
        }
        
        return WINNER.NOBODY;
    }

    private static WINNER checkHorizontally(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            if (checkLine(ImageCache.TICTACTOE_O, buttonMatrix[i])) {
                return WINNER.O;
            }
            if (checkLine(ImageCache.TICTACTOE_X, buttonMatrix[i])) {
                return WINNER.X;
            }
        }

        return WINNER.NOBODY;
    }

    private static WINNER checkVertically(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            if (checkColumn(ImageCache.TICTACTOE_O, buttonMatrix, i)) {
                return WINNER.O;
            }
            if (checkColumn(ImageCache.TICTACTOE_X, buttonMatrix, i)) {
                return WINNER.X;
            }
        }

        return WINNER.NOBODY;
    }

    private static boolean checkColumn(final ImageCache img, final JButton[][] buttonMatrix, final int index) {
        return buttonMatrix[0][index].getIcon() == img.getImageIcon()
                && buttonMatrix[1][index].getIcon() == img.getImageIcon()
                && buttonMatrix[2][index].getIcon() == img.getImageIcon();
    }

    private static boolean checkLine(final ImageCache img, final JButton[] buttonLine) {
        if (buttonLine.length != 3) {
            return false;
        }

        return buttonLine[0].getIcon() == img.getImageIcon() && buttonLine[1].getIcon() == img.getImageIcon() && buttonLine[2].getIcon() == img.getImageIcon();
    }

}
