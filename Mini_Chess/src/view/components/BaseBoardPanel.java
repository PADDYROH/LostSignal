package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		updateTiles();
		
	}
	
	public void updateTiles() {
		tileArray[0][0].add(new JLabel("hello"));
		tileArray[0][0].revalidate();
		tileArray[0][0].repaint();
		revalidate();
		repaint();
	}

}
