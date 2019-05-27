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
	private JPanel whitePlayerPanel;
	private JPanel blackPlayerPanel;
	
	public BasePlayerPanel(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		setBackground(new Color(243,220,187));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 1), (new EmptyBorder(10, 10, 10, 10))));
		
		JLabel heading = new JLabel("Summary");
		heading.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		//heading.setFont(FontTools.HEADING_2);
		add(heading);
		
		
		//JLabel playersHeading = new JLabel("Players:");
		//playersHeading.setFont(FontTools.HEADING_3);
		//playersHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		//add(playersHeading);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(2,1));
		
		whitePlayerPanel = new JPanel();
		whitePlayerLabel = new JLabel("White Player");
		whitePlayerPanel.setLayout(new BoxLayout(whitePlayerPanel, BoxLayout.Y_AXIS));
		whitePlayerPanel.setBorder(BorderFactory.createMatteBorder(2,0,2,0, Color.BLACK));
		whitePlayerPanel.add(whitePlayerLabel);
		
		blackPlayerPanel = new JPanel();
		blackPlayerLabel = new JLabel("Black Player");
		blackPlayerPanel.setLayout(new BoxLayout(blackPlayerPanel, BoxLayout.Y_AXIS));
		//blackPlayerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		blackPlayerPanel.add(blackPlayerLabel);
		
		playerPanel.add(whitePlayerPanel);
		whitePlayerPanel.setBackground(null);
		playerPanel.add(blackPlayerPanel);
		blackPlayerPanel.setBackground(null);
		playerPanel.setBackground(null);
		add(playerPanel);
		
		updatePlayerList();
	}
	
	public void updatePlayerList() {
//		Player whitePlayer = mainFrame.getGUIModel().getMainEngine().getWhitePlayer();
//		Player blackPlayer = mainFrame.getGUIModel().getMainEngine().getBlackPlayer();
		whitePlayerPanel.removeAll();
		whitePlayerPanel.add(whitePlayerLabel);
		
		blackPlayerPanel.removeAll();
		blackPlayerPanel.add(blackPlayerLabel);
		Player[] tempPlayers = new Player[2];
		tempPlayers[0] = mainFrame.getGUIModel().getMainEngine().getWhitePlayer();
		tempPlayers[1] = mainFrame.getGUIModel().getMainEngine().getBlackPlayer();
		
		for(int i = 0; i < tempPlayers.length; i++) {
			Player tempPlayer = tempPlayers[i];
			JPanel tempPanel = i == 0 ? whitePlayerPanel : blackPlayerPanel;
			if(tempPlayer != null) {
				String[] details = new String[4];
				details[0] = "ID: " + tempPlayer.getID();
				details[1] = "Name: " + tempPlayer.getName();
				details[2] = "Total Points: " + tempPlayer.getPoints();
				int tempPoints = 0;
				if(i == 0) {
					tempPoints = mainFrame.getGUIModel().getMainEngine().getWhitePlayerPoints();
				} else {
					tempPoints = mainFrame.getGUIModel().getMainEngine().getBlackPlayerPoints();
				}
				details[3] = "Current Points: " + tempPoints;
				tempPanel.add(new JLabel(" "));
				for(int c = 0; c < details.length; c++) {
					tempPanel.add(new JLabel(details[c]));
				}
			} 
		}
		
		
		revalidate();
		repaint();
	}
	
}
