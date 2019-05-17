package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseBoardPanel extends JPanel {
	BaseFrame mainFrame;
	
	public BaseBoardPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		//setBackground(new Color(50, 50, 50));
		//setForeground(new Color(0, 0, 255));
		setLayout(new GridLayout(6, 6));
		setBorder(BorderFactory.createLineBorder(new Color(25, 250, 0)));
		
		for(int i = 0; i < 36; i++) {
			add(new JLabel("square"));
		}
		
		
		
	}

}
