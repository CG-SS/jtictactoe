package jtictactoe.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jtictactoe.gui.panels.Screen;

/**
 *
 * @author CGSS
 */
public class TicTacToeMainFrame extends JFrame {
    
    private Screen currentScreen = Screen.MAIN_MENU;
    
    public TicTacToeMainFrame() {
        super("Tic Tac Toe");
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setMinimumSize(new Dimension(800, 600));
        super.add(currentScreen.getPanel());
    }
    
    public void changeScreen(final Screen screen) {
        this.remove(currentScreen.getPanel());
        currentScreen.getPanel().setVisible(false);
        currentScreen = screen;
        this.add(currentScreen.getPanel());
        currentScreen.getPanel().setVisible(true);
        this.invalidate();
        this.validate();
    }
    
}
