/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtictactoe.gui.panels;

import javax.swing.JPanel;

/**
 *
 * @author CGSS
 */
public enum Screen {
    
    MAIN_MENU(new MainMenuPanel()),
    PLAYER_CHOOSE(new PlayerChoosePanel()),
    VICTORY_PANEL(new VictoryPanel()),
    VS_COMPUTER_GAME(new VsComputerGamePanel()),
    VS_PLAYER_GAME(new VsPlayerGamePanel());
    
    private final JPanel panel;
    
    Screen(final JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
