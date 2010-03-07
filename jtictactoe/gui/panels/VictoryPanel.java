/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtictactoe.gui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jtictactoe.gui.context.GuiContext;

/**
 *
 * @author CGSS
 */
public class VictoryPanel extends JPanel {
    
    private final JButton backButton;
    private final JLabel victoryTextLabel;

    public void setVictoryText(final String victoryText) {
        victoryTextLabel.setText(victoryText);
    }
    
    public VictoryPanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
        
        victoryTextLabel = new JLabel();
        victoryTextLabel.setAlignmentX(CENTER_ALIGNMENT);
        victoryTextLabel.setAlignmentY(CENTER_ALIGNMENT);
        auxPanel.add(victoryTextLabel);
        
        backButton = new JButton("Go Back");
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        backButton.setAlignmentY(CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.changeScreen(Screen.MAIN_MENU);
                }
            }
            
        });
        auxPanel.add(backButton);
        
        super.add(Box.createHorizontalGlue());
        super.add(auxPanel);
        super.add(Box.createHorizontalGlue());
    }
    
}
