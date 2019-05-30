package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel {
	private JLabel currentPlayerLabel;
	private JLabel numTurnsLabel;
	private JLabel maxTurnsLabel;
	private BaseFrame mainFrame;

	public StatusPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBackground(new Color(243, 220, 187));
		setLayout(new GridLayout(1, 1));
		// add 3 labels
		currentPlayerLabel = new JLabel();
		currentPlayerLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,2, Color.BLACK));
		numTurnsLabel = new JLabel();
		numTurnsLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,2, Color.BLACK));
		maxTurnsLabel = new JLabel();
		// use another panel to organise the labels into a 1x3 grid
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(1,3));
		
		infoPanel.add(currentPlayerLabel);
		infoPanel.add(numTurnsLabel);
		infoPanel.add(maxTurnsLabel);
		infoPanel.setBackground(null);
	
		add(infoPanel);

	}

	// update contents of the status panel
	public void updateInfo() {
		// get details from GUIModel
		String[] statusDetails = mainFrame.getGUIModel().getStatusDetails();
		currentPlayerLabel.setText(statusDetails[0]);
		
		numTurnsLabel.setText(statusDetails[1]);
		
		maxTurnsLabel.setText(statusDetails[2]);
		revalidate();
		repaint();
	}
	
}


