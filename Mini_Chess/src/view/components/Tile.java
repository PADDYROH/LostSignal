package view.components;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Tile extends JComponent {
	
	public Tile() {
		setLayout(null);
	}
	public void paint(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0,  0, getWidth(), getHeight());
	}
}
