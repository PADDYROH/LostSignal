package view.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import view.utilities.FontTools;

public class BasePlayerPanel extends  JPanel {
	
	BaseFrame mainFrame;
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
		
		JLabel whitePlayerLabel = new JLabel("Player1");
		add(whitePlayerLabel);
		
		JLabel blackPlayerLabel = new JLabel("Player1");
		add(blackPlayerLabel);
		
		updatePlayerList();
	}
	
	public void updatePlayerList() {
		
		
		revalidate();
		repaint();
	}

}
