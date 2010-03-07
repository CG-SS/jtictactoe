package jtictactoe.resources;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author CGSS
 */
public class ResourceLoader {

    static private final ClassLoader LOADER = ResourceLoader.class.getClassLoader();
    
    private ResourceLoader() {
    }

    public static Image loadImage(final String imagePath) {
        try {
            final URL resourceUrl = LOADER.getResource(imagePath);
            final Image img = ImageIO.read(resourceUrl);
            
            return img;
        } catch (final IOException ex) {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}
