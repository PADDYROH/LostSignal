package view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Player;

//import view.utilities.FontTools;

public class BasePlayerPanel extends  JPanel {
	
	private BaseFrame mainFrame;
	private JLabel whitePlayerLabel;
	private JLabel blackPlayerLabel;
	
	public BasePlayerPanel(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		setBackground(new Color(243,220,187));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 1), (new EmptyBorder(10, 10, 10, 10))));
		
		JLabel heading = new JLabel("Game Summary");
		//heading.setFont(FontTools.HEADING_2);
		add(heading);
		
		
		JLabel playersHeading = new JLabel("Players:");
		//playersHeading.setFont(FontTools.HEADING_3);
		playersHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		add(playersHeading);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(2,1));
		add(playerPanel);
		
		whitePlayerLabel = new JLabel("White Player");
		playerPanel.add(whitePlayerLabel);
		
		blackPlayerLabel = new JLabel("Black Player");
		playerPanel.add(blackPlayerLabel);
		
		updatePlayerList();
	}
	
	public void updatePlayerList() {
		Player whitePlayer = mainFrame.getGUIModel().getMainEngine().getWhitePlayer();
		Player blackPlayer = mainFrame.getGUIModel().getMainEngine().getBlackPlayer();
		if(whitePlayer != null) {
			whitePlayerLabel.setText("White Player\n" + whitePlayer.toString() + "Current Points: " + mainFrame.getGUIModel().getMainEngine().getWhitePlayerPoints());
		}
		if(blackPlayer != null) {
			blackPlayerLabel.setText("Black Player\n" + blackPlayer.toString() + "Current Points: " + mainFrame.getGUIModel().getMainEngine().getBlackPlayerPoints());
		}
		
		revalidate();
		repaint();
	}

}
