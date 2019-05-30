package view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class BasePlayerPanel extends JPanel {

	private BaseFrame mainFrame;
	private JLabel whitePlayerLabel;
	private JLabel blackPlayerLabel;
	private JPanel whitePlayerPanel;
	private JPanel blackPlayerPanel;

	public BasePlayerPanel(BaseFrame mainFrame) {
		this.mainFrame = mainFrame;
		// set borders and layout
		setBackground(new Color(243, 220, 187));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(
				BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 1), (new EmptyBorder(10, 10, 10, 10))));
		
		JLabel heading = new JLabel("Summary");
		heading.setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 0));
		add(heading);
		
		// panel used to organise white and black player info
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(2, 1));
		// add label and set layout to white player panel
		whitePlayerPanel = new JPanel();
		whitePlayerLabel = new JLabel("White Player         ");
		whitePlayerPanel.setLayout(new BoxLayout(whitePlayerPanel, BoxLayout.Y_AXIS));
		whitePlayerPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
		whitePlayerPanel.add(whitePlayerLabel);
		// add label and set layout to black player panel
		blackPlayerPanel = new JPanel();
		blackPlayerLabel = new JLabel("Black Player         ");
		blackPlayerPanel.setLayout(new BoxLayout(blackPlayerPanel, BoxLayout.Y_AXIS));
		blackPlayerPanel.add(blackPlayerLabel);

		// add player panels
		playerPanel.add(whitePlayerPanel);
		whitePlayerPanel.setBackground(null);
		playerPanel.add(blackPlayerPanel);
		blackPlayerPanel.setBackground(null);
		playerPanel.setBackground(null);
		add(playerPanel);

		updatePlayerList();
	}

	public void updatePlayerList() {
		whitePlayerPanel.removeAll();
		whitePlayerPanel.add(whitePlayerLabel);

		blackPlayerPanel.removeAll();
		blackPlayerPanel.add(blackPlayerLabel);
		// get relevant details from GUIModel
		// update panels with details for each player
		String[][] details = mainFrame.getGUIModel().getPlayerDetails();
		for (int i = 0; i < details.length; i++) {
			// white player panel is first (index = 0)
			JPanel tempPanel = i == 0 ? whitePlayerPanel : blackPlayerPanel;
			if (details[i] != null) {

				tempPanel.add(new JLabel(" "));

				for (int c = 0; c < details[i].length; c++) {
					tempPanel.add(new JLabel(details[i][c]));
				}
			}
		}

		revalidate();
		repaint();
	}

}
