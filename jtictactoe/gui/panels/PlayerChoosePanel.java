/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtictactoe.gui.panels;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import jtictactoe.gui.context.GuiContext;

/**
 *
 * @author CGSS
 */
public class PlayerChoosePanel extends JPanel {
    
    private final JButton vsPlayerButton;
    private final JButton vsComputerButton;
    private final JButton backButton;

    public PlayerChoosePanel() {
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
        
        vsPlayerButton = new JButton("vs Player");
        vsComputerButton = new JButton("vs Computer");
        backButton = new JButton("Go Back");
        
        vsPlayerButton.setAlignmentX(CENTER_ALIGNMENT);
        vsPlayerButton.setAlignmentY(CENTER_ALIGNMENT);
        vsPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.changeScreen(Screen.VS_PLAYER_GAME);
                }
            }
        });
        
        vsComputerButton.setAlignmentX(CENTER_ALIGNMENT);
        vsComputerButton.setAlignmentY(CENTER_ALIGNMENT);
        vsComputerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.changeScreen(Screen.VS_COMPUTER_GAME);
                }
            }
        });
        
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        backButton.setAlignmentY(CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(GuiContext.mainFrame != null){
                    GuiContext.mainFrame.changeScreen(Screen.MAIN_MENU);
                }
            }
        });
        
        auxPanel.add(vsPlayerButton);
        auxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        auxPanel.add(vsComputerButton);
        auxPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        auxPanel.add(backButton);
        
        super.add(Box.createHorizontalGlue());
        super.add(auxPanel);
        super.add(Box.createHorizontalGlue());
    }
    
}
