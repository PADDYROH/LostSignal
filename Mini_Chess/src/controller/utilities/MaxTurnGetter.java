package controller.utilities;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MaxTurnGetter {
	private JTextField numberField;
	private JPanel panel;
	
	public MaxTurnGetter() {
		numberField = new JTextField();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}

	public int getTurns(String playerMessage) {
		// TODO Auto-generated method stub
		JLabel numLabel = new JLabel(playerMessage + " Desired Turns:");
		numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// set font
		panel.add(numLabel);
		panel.add(numberField);
		int turns = 0;
		int result = JOptionPane.showConfirmDialog(null, panel, "Register Player", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon());
		if (result == JOptionPane.OK_OPTION) {
			turns = Integer.parseInt(numberField.getText());
		}
		return turns;
	}

}
