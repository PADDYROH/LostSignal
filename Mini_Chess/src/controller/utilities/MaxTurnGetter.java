package controller.utilities;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.components.BaseFrame;
import view.model.GUIModel;

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
		// create labels and text fields for user input
		JLabel numLabel = new JLabel(playerMessage + " Desired Max Turns:");
		numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(numLabel);
		panel.add(numberField);
		GUIModel.updateFonts(panel);
		int turns = 0;
		// show dialog and get input
		int result = JOptionPane.showConfirmDialog(mainFrame, panel, "Choose Max Turns", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, new ImageIcon());
		// return int input (0 is invalid) if OK, or 0 if cancel
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
