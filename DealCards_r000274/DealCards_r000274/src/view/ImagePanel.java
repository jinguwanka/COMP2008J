package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private Image image;

    /**
     * Create the panel.
     */
    public ImagePanel(String imageString) {
        loadImage(imageString);
    }

    private void loadImage(String imageString) {
        if (imageString == null) {
            return;
        }

        try {
            image = ImageIO.read(new File("images/" + imageString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setImageString(String imageString) {
        loadImage(imageString);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            return;
        }
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 120);
    }
}
