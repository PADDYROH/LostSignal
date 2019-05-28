package controller.utilities;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.components.BaseFrame;

public class MaxTurnGetter {
	private JTextField numberField;
	private JPanel panel;
	private BaseFrame mainFrame;
	
	public MaxTurnGetter(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		numberField = new JTextField();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}

	public int getTurns(String playerMessage) {
		// TODO Auto-generated method stub
		JLabel numLabel = new JLabel(playerMessage + " Desired Max Turns:");
		numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// set font
		panel.add(numLabel);
		panel.add(numberField);
		int turns = 0;
		int result = JOptionPane.showConfirmDialog(mainFrame, panel, "Choose Max Turns", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon());
		if (result == JOptionPane.OK_OPTION) {
			try {
				turns = Integer.parseInt(numberField.getText());
			} catch (NumberFormatException e) {
				turns = 0;
			}
		}
		return turns;
	}

}
