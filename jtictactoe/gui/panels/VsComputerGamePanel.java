package jtictactoe.gui.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import jtictactoe.gui.context.GuiContext;
import jtictactoe.logic.BlockWinComputerPlayerLogic;
import jtictactoe.logic.ComputerPlayerLogic;
import jtictactoe.logic.LogicHelper;
import jtictactoe.resources.ImageCache;

/**
 *
 * @author CGSS
 */
public class VsComputerGamePanel extends JPanel {
    
    private final JButton[][] buttonMatrix;
    private final ComputerPlayerLogic computerPlayerLogic = new BlockWinComputerPlayerLogic();
    private boolean isPlayerOneRound = true;
    private int rounds = 0;

    class VsComputerButtonListener implements ActionListener {

        private final JButton button;

        public VsComputerButtonListener(final JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(final ActionEvent e) {
            if (button.getIcon() == null) {
                rounds++;

                if (isPlayerOneRound) {
                    button.setIcon(ImageCache.TICTACTOE_X.getImageIcon());
                } else {
                    button.setIcon(ImageCache.TICTACTOE_O.getImageIcon());
                }

                isPlayerOneRound = !isPlayerOneRound;

                final LogicHelper.WINNER winner = LogicHelper.isWinningState(buttonMatrix);

                if (winner != LogicHelper.WINNER.NOBODY) {
                    final String victoryText = "Victory to " + ((winner == LogicHelper.WINNER.O) ? "computer" : "player") + "!";
                    endWithText(victoryText);
                } else if (rounds >= 9) {
                    endWithText("Draw!");
                } else if(!isPlayerOneRound){
                    final JButton computerButton = computerPlayerLogic.selectButton(buttonMatrix);
                    
                    if(computerButton != null){
                        for(int i = 0; i < computerButton.getActionListeners().length; i++){
                            computerButton.getActionListeners()[i].actionPerformed(e);
                        }
                    }
                }
            }
        }
    }

    public VsComputerGamePanel() {
        super.setLayout(new GridLayout(0, 3));

        buttonMatrix = new JButton[3][3];

        buttonMatrix[0][0] = new JButton();
        buttonMatrix[0][0].addActionListener(new VsComputerButtonListener(buttonMatrix[0][0]));
        super.add(buttonMatrix[0][0]);
        buttonMatrix[0][1] = new JButton();
        buttonMatrix[0][1].addActionListener(new VsComputerButtonListener(buttonMatrix[0][1]));
        super.add(buttonMatrix[0][1]);
        buttonMatrix[0][2] = new JButton();
        buttonMatrix[0][2].addActionListener(new VsComputerButtonListener(buttonMatrix[0][2]));
        super.add(buttonMatrix[0][2]);

        buttonMatrix[1][0] = new JButton();
        buttonMatrix[1][0].addActionListener(new VsComputerButtonListener(buttonMatrix[1][0]));
        super.add(buttonMatrix[1][0]);
        buttonMatrix[1][1] = new JButton();
        buttonMatrix[1][1].addActionListener(new VsComputerButtonListener(buttonMatrix[1][1]));
        super.add(buttonMatrix[1][1]);
        buttonMatrix[1][2] = new JButton();
        buttonMatrix[1][2].addActionListener(new VsComputerButtonListener(buttonMatrix[1][2]));
        super.add(buttonMatrix[1][2]);

        buttonMatrix[2][0] = new JButton();
        buttonMatrix[2][0].addActionListener(new VsComputerButtonListener(buttonMatrix[2][0]));
        super.add(buttonMatrix[2][0]);
        buttonMatrix[2][1] = new JButton();
        buttonMatrix[2][1].addActionListener(new VsComputerButtonListener(buttonMatrix[2][1]));
        super.add(buttonMatrix[2][1]);
        buttonMatrix[2][2] = new JButton();
        buttonMatrix[2][2].addActionListener(new VsComputerButtonListener(buttonMatrix[2][2]));
        super.add(buttonMatrix[2][2]);
    }

    private void endWithText(final String victoryText) {
        final VictoryPanel vp = (VictoryPanel) Screen.VICTORY_PANEL.getPanel();
        vp.setVictoryText(victoryText);

        resetGame();

        if (GuiContext.mainFrame != null) {
            GuiContext.mainFrame.changeScreen(Screen.VICTORY_PANEL);
        }
    }

    private void resetGame() {
        isPlayerOneRound = true;
        resetBoard();
        rounds = 0;
    }

    private void resetBoard() {
        for (int i = 0; i < buttonMatrix.length; i++) {
            for (int j = 0; j < buttonMatrix[i].length; j++) {
                buttonMatrix[i][j].setIcon(null);
            }
        }
    }

    
}
