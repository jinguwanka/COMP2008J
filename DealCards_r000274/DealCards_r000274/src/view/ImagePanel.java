package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private Image image;

	/**
	 * Create the panel.
	 */
	public ImagePanel(String imageString) {
		setSize(80, 120);
		if (imageString==null) {
			return;
		}
		
		try {
			image=ImageIO.read(new File("images/"+imageString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setSize(80, 120);

	}
	
	public void setImageString(String imageString) {
		try {
			image=ImageIO.read(new File("images/"+imageString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (image==null) {
			return;
		}
		g.drawImage(image, 0, 0, 80, 120, this);
	}

}
