package jtictactoe.resources;

import javax.swing.ImageIcon;

/**
 *
 * @author CGSS
 */
public enum ImageCache {

    TICTACTOE_X(new ImageIcon(ResourceLoader.loadImage("jtictactoe/resources/X.png"))),
    TICTACTOE_O(new ImageIcon(ResourceLoader.loadImage("jtictactoe/resources/O.png")));

    private final ImageIcon imageIcon;

    ImageCache(final ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

}
