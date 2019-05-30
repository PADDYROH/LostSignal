package view.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.TileListener;
import view.utilities.PieceIconTools;

public class Tile extends JPanel {
	private JLabel label;
	private JLabel label2;
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
		label.setHorizontalAlignment(JLabel.CENTER);
		label2 = new JLabel();
		add(label2);
		label2.setHorizontalAlignment(JLabel.CENTER);
		setBackground(defaultColor);
		this.addMouseListener(new TileListener(this));
	}

	public void setImage(ImageIcon icon) {
		label.setIcon(icon);
		remove(label2);
		repaint();
		revalidate();
		
	}
	
	public void setImage(ImageIcon icon, ImageIcon icon2) {
		if(icon2 == null) {
			setImage(icon);
		} else if (icon == null){
			setImage(icon2);
		}
		else {
			label.setIcon(PieceIconTools.getScaledImage(icon));
			label2.setIcon(PieceIconTools.getScaledImage(icon2));
			add(label2);
			repaint();
			revalidate();
		}
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
