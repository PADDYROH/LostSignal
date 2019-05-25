package view.components;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.piece.Piece;

public class BaseBoardPanel extends JPanel {
	private BaseFrame mainFrame;
	private Tile[][] tileArray;
	
	public BaseBoardPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		tileArray = new Tile[6][6];
		//setBackground(new Color(50, 50, 50));
		//setForeground(new Color(0, 0, 255));
		setLayout(new GridLayout(6, 6));
		setBorder(BorderFactory.createLineBorder(new Color(25, 250, 0)));
		
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 6; c++) {
				Tile tempTile = new Tile();
				if((r + c) % 2 == 0) {
					tempTile.setBackground(Color.GRAY);
				} else {
					tempTile.setBackground(Color.WHITE);
				}
				tileArray[r][c] = tempTile;
				add(tempTile);
			}
		}
		// make this take an array of strings, gotten from viewmodel
		updateTiles();
		
	}
	
	public void updateTiles() {
//		tileArray[0][0].setIcon(new ImageIcon("pieceImages" + File.separator + "BR.png"));
//		tileArray[0][0].revalidate();
//		tileArray[0][0].repaint();
//		add(new JLabel(new ImageIcon("pieceImages" + File.separator + "BR.png")));
//		revalidate();
//		repaint();
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 6; c++) {
				JLabel tempLabel = new JLabel();
				if((r + c) % 2 == 0) {
					tempLabel.setBackground(Color.GRAY);
				} else {
					tempLabel.setBackground(Color.WHITE);
				}
				if(mainFrame.getGUIModel().getMainEngine().getGameBoard().getPiece(r,c) instanceof)
				//tileArray[r][c] = tempLabel;
				add(tempLabel);
			}
		}
	}
	
	public String pieceToImageIcon(Piece piece) {
		if(mainFrame.getGUIModel().getMainEngine().getGameBoard().getPiece(r,c) instanceof)
	}

}
