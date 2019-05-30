package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BaseBoardPanel extends JPanel {
	private BaseFrame mainFrame;
	private Tile[][] tileArray;
	private static int ROWS = 6;
	private static int COLS = 6;

	public BaseBoardPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		tileArray = new Tile[ROWS][COLS];

		setLayout(new GridLayout(6, 6));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// add a 6x6 array of Tiles, alternating gray and white colours
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				Tile tile;
				if ((r + c) % 2 == 0) {
					tile = new Tile(this, c, r, Color.GRAY);
				} else {
					tile = new Tile(this, c, r, Color.WHITE);
				}
				tileArray[c][r] = tile;
				add(tileArray[c][r]);
			}
		}

	}

	public BaseFrame getMainFrame() {
		return mainFrame;
	}

	public Tile[][] getTiles() {
		return tileArray;
	}

}
