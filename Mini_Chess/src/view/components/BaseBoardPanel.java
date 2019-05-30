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
import view.utilities.PieceIconTools;

public class BaseBoardPanel extends JPanel {
	private BaseFrame mainFrame;
	private Tile[][] tileArray;
	
	public BaseBoardPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		tileArray = new Tile[6][6];
		
		setLayout(new GridLayout(6, 6));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	
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
		//mainFrame.getGUIModel().updateTiles();
		
		
	}
		
		
	public BaseFrame getMainFrame() {
		return mainFrame;
	}
	
	public Tile[][] getTiles(){
		return tileArray;
	}
	
	

}
