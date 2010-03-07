package jtictactoe;

import jtictactoe.gui.TicTacToeMainFrame;
import jtictactoe.gui.context.GuiContext;


/**
 * Jtictactoe.
 * A Tic Tac Toe game implemented fully in Java.
 * Doesn't have any fancy UI or interaction.
 * Create as a learning project.
 * 
 * @author CG-SS
 */
public class Jtictactoe {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        final Jtictactoe jtictactoe = new Jtictactoe();
        jtictactoe.start();
    }
    
    public void start() {
        final TicTacToeMainFrame ticTacToeFrame = new TicTacToeMainFrame();
        GuiContext.mainFrame = ticTacToeFrame;
        ticTacToeFrame.setVisible(true);
    }
    
}
