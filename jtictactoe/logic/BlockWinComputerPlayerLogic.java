package jtictactoe.logic;

import java.util.ArrayList;
import javax.swing.JButton;
import jtictactoe.gui.context.GuiContext;
import jtictactoe.resources.ImageCache;

/**
 *
 * @author CGSS
 */
public class BlockWinComputerPlayerLogic implements ComputerPlayerLogic {

    @Override
    public JButton selectButton(final JButton[][] buttonMatrix) {
        JButton returnBtn;

        returnBtn = checkIfWillLose(buttonMatrix);
        if(returnBtn != null){
            return returnBtn;
        }
        
        returnBtn = checkIfWillWin(buttonMatrix);
        if(returnBtn != null){
            return returnBtn;
        }

        final ArrayList<JButton> arBtn = new ArrayList<JButton>();
        for (int i = 0; i < buttonMatrix.length; i++) {
            for (int j = 0; j < buttonMatrix[i].length; j++) {
                if (buttonMatrix[i][j].getIcon() == null) {
                    arBtn.add(buttonMatrix[i][j]);
                }
            }
        }

        if (!arBtn.isEmpty()) {
            return arBtn.get(GuiContext.rand.nextInt(arBtn.size()));
        }

        return null;
    }
    
    private JButton checkIfWillWin(final JButton[][] buttonMatrix){
        JButton returnBtn;

        returnBtn = checkHorizontallyWin(buttonMatrix);
        if (returnBtn != null) {
            return returnBtn;
        }

        returnBtn = checkVerticallyWin(buttonMatrix);
        if (returnBtn != null) {
            return returnBtn;
        }

        return checkDiagonallyWin(buttonMatrix);
    }
    
    private JButton checkHorizontallyWin(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            final JButton[] line = {buttonMatrix[i][0], buttonMatrix[i][1], buttonMatrix[i][2]};
            final JButton btn = checkLineWin(line);

            if (btn != null) {
                return btn;
            }
        }

        return null;
    }
    
    private JButton checkDiagonallyWin(final JButton[][] buttonMatrix) {
        final JButton[] firstDiagonal = {buttonMatrix[0][0], buttonMatrix[1][1], buttonMatrix[2][2]};
        final JButton possibleBtn1 = checkLineWin(firstDiagonal);

        if (possibleBtn1 != null) {
            return possibleBtn1;
        }

        final JButton[] secondDiagonal = {buttonMatrix[0][2], buttonMatrix[1][1], buttonMatrix[2][0]};
        return checkLineWin(secondDiagonal);
    }
    
    private JButton checkVerticallyWin(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            final JButton[] line = {buttonMatrix[0][i], buttonMatrix[1][i], buttonMatrix[2][i]};
            final JButton btn = checkLineWin(line);

            if (btn != null) {
                return btn;
            }
        }

        return null;
    }
    
    private JButton checkLineWin(final JButton[] line) {
        if (line[0].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                && line[1].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                && line[2].getIcon() == null) {
            return line[2];
        }

        if (line[0].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                && line[1].getIcon() == null
                && line[2].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()) {
            return line[1];
        }

        if (line[0].getIcon() == null
                && line[1].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()
                && line[2].getIcon() == ImageCache.TICTACTOE_O.getImageIcon()) {
            return line[0];
        }

        return null;
    }
    
    private JButton checkIfWillLose(final JButton[][] buttonMatrix) {
        JButton returnBtn;

        returnBtn = checkHorizontallyLose(buttonMatrix);
        if (returnBtn != null) {
            return returnBtn;
        }

        returnBtn = checkVerticallyLose(buttonMatrix);
        if (returnBtn != null) {
            return returnBtn;
        }

        return checkDiagonallyLose(buttonMatrix);
    }

    private JButton checkHorizontallyLose(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            final JButton[] line = {buttonMatrix[i][0], buttonMatrix[i][1], buttonMatrix[i][2]};
            final JButton btn = checkLineLose(line);

            if (btn != null) {
                return btn;
            }
        }

        return null;
    }

    private JButton checkVerticallyLose(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            final JButton[] line = {buttonMatrix[0][i], buttonMatrix[1][i], buttonMatrix[2][i]};
            final JButton btn = checkLineLose(line);

            if (btn != null) {
                return btn;
            }
        }

        return null;
    }

    private JButton checkDiagonallyLose(final JButton[][] buttonMatrix) {
        final JButton[] firstDiagonal = {buttonMatrix[0][0], buttonMatrix[1][1], buttonMatrix[2][2]};
        final JButton possibleBtn1 = checkLineLose(firstDiagonal);

        if (possibleBtn1 != null) {
            return possibleBtn1;
        }

        final JButton[] secondDiagonal = {buttonMatrix[0][2], buttonMatrix[1][1], buttonMatrix[2][0]};
        return checkLineLose(secondDiagonal);
    }

    private JButton checkLineLose(final JButton[] line) {
        if (line[0].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                && line[1].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                && line[2].getIcon() == null) {
            return line[2];
        }

        if (line[0].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                && line[1].getIcon() == null
                && line[2].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()) {
            return line[1];
        }

        if (line[0].getIcon() == null
                && line[1].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()
                && line[2].getIcon() == ImageCache.TICTACTOE_X.getImageIcon()) {
            return line[0];
        }

        return null;
    }
}
