package view.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.TileListener;

public class Tile extends JPanel {
	private JLabel label;
	private BaseBoardPanel mainBoardPanel;
	private int xPos;
	private Color defaultColor;
	private Border defaultBorder;

	private int yPos;
	
	public Tile(BaseBoardPanel mainBoardPanel, int xPos, int yPos, Color defaultColor) {
		this.mainBoardPanel = mainBoardPanel;
		
		this.defaultColor = defaultColor;
		this.xPos = xPos;
		this.yPos = yPos;
		setLayout(new GridLayout(1,1));
		label = new JLabel();
		add(label);
		setBackground(defaultColor);
		this.addMouseListener(new TileListener(this));
	}

	public void setImage(ImageIcon icon) {
		label.setIcon(icon);
		repaint();
		revalidate();
		
	}
	
	public BaseBoardPanel getMainBoardPanel() {
		return mainBoardPanel;
	}
	
	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}
	
	public void updateBorder(Border newBorder) {
		this.defaultBorder = newBorder;
		setBorder(newBorder);
	}
	
	public Border getDefaultBorder() {
		return defaultBorder;
	}
}
