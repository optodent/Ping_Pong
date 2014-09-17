import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//importing images for the game from files
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

    private Image image = null;

    public ImagePanel(String filename) {
        this.image = new ImageIcon(filename).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       //seting the size of the image
        g.drawImage(image, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
    }
}
