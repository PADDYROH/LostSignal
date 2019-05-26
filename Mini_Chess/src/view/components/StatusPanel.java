package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.Player;

//import view.utilities.FontTools;

public class StatusPanel extends JPanel {
	//private JLabel label1;
	private JLabel currentPlayerLabel;
	private JLabel numTurnsLabel;
	private JLabel maxTurnsLabel;
	private BaseFrame mainFrame;

	public StatusPanel(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		setBackground(new Color(243, 220, 187));
		setLayout(new GridLayout(1, 1));
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		// three labels are added, which will show the last 3 statuses
		//label1 = new JLabel();
		currentPlayerLabel = new JLabel();
		currentPlayerLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,2, Color.BLACK));
		numTurnsLabel = new JLabel();
		numTurnsLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,2, Color.BLACK));
		maxTurnsLabel = new JLabel();
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1,3));
		
		infoPanel.add(currentPlayerLabel);
		infoPanel.add(numTurnsLabel);
		infoPanel.add(maxTurnsLabel);
		infoPanel.setBackground(null);
		//label1.setFont(FontTools.STATUS);
		add(infoPanel);
		updateInfo();
//		label1.setText("Welcome");
//		label1.setHorizontalAlignment(SwingConstants.LEFT);
//		label1.setBorder(border1);
//		add(label1);
	}

//	public void notifyMessage(String message) {
//		label1.setText(message);
//		revalidate();
//		repaint();
//	}
	
	public void updateInfo() {
		String tempID = "";
		Player tempPlayer = mainFrame.getGUIModel().getMainEngine().getCurrentPlayer();
		if(tempPlayer != null) {
			tempID = tempPlayer.getName() + "(" + tempPlayer.getID() + ")";
		}
		currentPlayerLabel.setText("Current Player: " + tempID);
		
		numTurnsLabel.setText("Turns Played: " + mainFrame.getGUIModel().getMainEngine().getNumTurns()/2);
		
		maxTurnsLabel.setText("Max Turns: " + + mainFrame.getGUIModel().getMainEngine().getMaxTurns()/2);
		revalidate();
		repaint();
	}
	
}


