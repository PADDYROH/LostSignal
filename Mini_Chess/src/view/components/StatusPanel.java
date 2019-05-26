package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

//import view.utilities.FontTools;

public class StatusPanel extends JPanel {
	private JLabel label1;

	public StatusPanel(BaseFrame baseFrame) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(243, 220, 187));
		setLayout(new GridLayout(1, 1));
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		// three labels are added, which will show the last 3 statuses
		label1 = new JLabel();
		//label1.setFont(FontTools.STATUS);
		label1.setText("No status");
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setBorder(border1);
		add(label1);
	}

	public void updateStatus(String message) {
		label1.setText(message);
		revalidate();
		repaint();
	}
}


