package jtictactoe.logic;

import javax.swing.JButton;

/**
 *
 * @author CGSS
 */
public class RandomComputerPlayerLogic implements ComputerPlayerLogic {

    @Override
    public JButton selectButton(final JButton[][] buttonMatrix) {
        for (int i = 0; i < buttonMatrix.length; i++) {
            for (int j = 0; j < buttonMatrix[i].length; j++) {
                if(buttonMatrix[i][j].getIcon() == null){
                    return buttonMatrix[i][j];
                }
            }
        }
        
        return null;
    }
    
}
