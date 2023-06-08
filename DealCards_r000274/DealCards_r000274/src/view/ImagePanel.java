package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class ImagePanel extends JPanel {
	
	private Image image;

	/**
	 * Create the panel.
	 */
	private JPopupMenu popupMenu = new JPopupMenu();
	private JMenuItem mntmNewMenuItem = new JMenuItem("DealCard");
	public ImagePanel(String imageString) {
		setSize(80, 120);
		
		
		
		
		
		popupMenu.add(mntmNewMenuItem);
		
		if (imageString==null) {
			return;
		}
		
		try {
			image=ImageIO.read(new File("images/"+imageString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("images/"+imageString);
			e.printStackTrace();
		}
		//setSize(80, 120);

	}
	
	public void displayPopMenu() {
		addPopup(this, popupMenu);
	}
	
	public void addMenuAction(ActionListener actionListener) {
		mntmNewMenuItem.addActionListener(actionListener);
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

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
