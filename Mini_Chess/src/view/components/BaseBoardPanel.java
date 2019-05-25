package view.components;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.piece.Bishop;
import model.piece.Piece;
import model.piece.Rook;

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
		
//		for(int r = 0; r < 6; r++) {
//			for(int c = 0; c < 6; c++) {
//				Tile tempTile = new Tile();
//				if((r + c) % 2 == 0) {
//					tempTile.setBackground(Color.GRAY);
//				} else {
//					tempTile.setBackground(Color.WHITE);
//				}
//				tileArray[r][c] = tempTile;
//				add(tempTile);
//			}
//		}
	
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 6; c++) {
				Tile tile; 
				if((r + c) % 2 == 0) {
					tile = new Tile(this, c, r, Color.GRAY);
				} else {
					tile = new Tile(this, c, r, Color.WHITE);
				}
				tileArray[c][r] = tile;
				add(tileArray[c][r]);
			}
		}
		// could take array of strings or something from gui model, eliminate that connection to engine
		updateTiles();
		
		
	}
	
	// change this to take array of string filepaths from gui model
	public void updateTiles() {
//		tileArray[0][0].setIcon(new ImageIcon("pieceImages" + File.separator + "BR.png"));
//		tileArray[0][0].revalidate();
//		tileArray[0][0].repaint();
//		add(new JLabel(new ImageIcon("pieceImages" + File.separator + "BR.png")));
//		revalidate();
//		repaint();
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 6; c++) {
				Piece basePiece = mainFrame.getGUIModel().getMainEngine().getGameBoard().getPiece(c,r);
				Piece mergedPiece = null;//tempPiece.getMergedPiece();
				ImageIcon baseIcon = pieceToImageIcon(basePiece);
				ImageIcon mergedIcon = null;
				if(mergedPiece != null) {
					mergedIcon = pieceToImageIcon(mergedPiece);
				}
				if(basePiece == null) {
					baseIcon = null;
				}
				tileArray[c][r].setImage(baseIcon, mergedIcon);
				//tileArray[r][c] = tempLabel;
				//add(tile);
			}
		}
		repaint();
		revalidate();
	}
	
	public ImageIcon pieceToImageIcon(Piece piece) {
		return new ImageIcon(pieceToPath(piece));
	
	}
	
	private String pieceToPath(Piece piece) {
		String path = "";
		if(piece != null) {
			String color;
			String type;
			if(piece.getColor() == "white") {
				color = "W";
			} else {
				color = "B"; 
			}
			if(piece instanceof Rook) {
				type = "R";
			} else if (piece instanceof Bishop) {
				type = "B";
			} else {
				type = "K";
			}
			
			path = "pieceImages" + File.separator + color + type + ".png";
		}
		return path;
	}
	
	public BaseFrame getMainFrame() {
		return mainFrame;
	}
	
	public Tile[][] getTiles(){
		return tileArray;
	}
	
	

}
