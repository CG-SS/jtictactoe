/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtictactoe.gui.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import jtictactoe.gui.context.GuiContext;

/**
 *
 * @author CGSS
 */
public class MainMenuPanel extends JPanel {
    
    private final JButton startGameButton;
    private final JButton exitGameButton;
    
    public MainMenuPanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
        
        startGameButton = new JButton("Start Game");
        exitGameButton = new JButton("Exit Game");
        
        startGameButton.setAlignmentX(CENTER_ALIGNMENT);
        startGameButton.setAlignmentY(CENTER_ALIGNMENT);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.changeScreen(Screen.PLAYER_CHOOSE);
                }
            }
        });
        
        exitGameButton.setAlignmentX(CENTER_ALIGNMENT);
        exitGameButton.setAlignmentY(CENTER_ALIGNMENT);
        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.dispatchEvent(new WindowEvent(GuiContext.mainFrame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        
        auxPanel.add(startGameButton);
        auxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        auxPanel.add(exitGameButton);
        
        super.add(Box.createHorizontalGlue());
        super.add(auxPanel);
        super.add(Box.createHorizontalGlue());
    }
    
}
