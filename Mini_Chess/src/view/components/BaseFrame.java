package view.components;

import java.awt.*;

import javax.swing.*;


import view.UserInterfaceManager;
import view.model.GUIModel;

@SuppressWarnings("serial")
public class BaseFrame extends JFrame{
	private UserInterfaceManager uIManager;
	private GUIModel gUIModel;
	private BasePlayerPanel mainPlayerPanel;
	private BaseBoardPanel mainBoardPanel;
	private BaseMenuBar mainMenuBar;
	
	public BaseFrame(UserInterfaceManager uIManager, GUIModel gUIModel) {
		super("Mini Chess");
		this.uIManager = uIManager;
		this.gUIModel = gUIModel;
		
		setSize(1000,1000);
		setMinimumSize(new Dimension(500,500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//set frame icon
		
		//add(new JLabel("HELLO THERE."), BorderLayout.NORTH);
		//add(new JLabel("GENERAL KENOBI."), BorderLayout.SOUTH);
		
		mainPlayerPanel = new BasePlayerPanel();
		add(mainPlayerPanel, BorderLayout.WEST);
		
		mainBoardPanel = new BaseBoardPanel(this);
		add(mainBoardPanel, BorderLayout.CENTER);
		
		mainMenuBar = new BaseMenuBar(this);
		setJMenuBar(mainMenuBar);
		
		// may put status panel here??
		
		
		setVisible(true);
	}
}
