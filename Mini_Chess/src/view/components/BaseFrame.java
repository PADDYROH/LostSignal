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
	private StatusPanel mainStatusPanel;
	
	public BaseFrame(UserInterfaceManager uIManager, GUIModel gUIModel) {
		super("Mini Chess");
		this.uIManager = uIManager;
		this.gUIModel = gUIModel;
		
		setSize(1000,1000);
		setMinimumSize(new Dimension(900,900));
		setMaximumSize(new Dimension(1100, 1100));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//set frame icon
		
		//add(new JLabel("HELLO THERE."), BorderLayout.NORTH);
		//add(new JLabel("GENERAL KENOBI."), BorderLayout.SOUTH);
		
		mainPlayerPanel = new BasePlayerPanel(this);
		add(mainPlayerPanel, BorderLayout.WEST);
		
		mainBoardPanel = new BaseBoardPanel(this);
		add(mainBoardPanel, BorderLayout.CENTER);
		
		mainStatusPanel = new StatusPanel(this);
		add(mainStatusPanel, BorderLayout.SOUTH);
		
		mainMenuBar = new BaseMenuBar(this);
		setJMenuBar(mainMenuBar);
			
		
		setVisible(true);
	}
	
	public UserInterfaceManager getUIManager() {
		return uIManager;
	}

	public GUIModel getGUIModel() {
		return gUIModel;
	}

	public BasePlayerPanel getMainPlayerPanel() {
		return mainPlayerPanel;
	}

	public BaseBoardPanel getMainBoardPanel() {
		return mainBoardPanel;
	}

	public BaseMenuBar getMainMenuBar() {
		return mainMenuBar;
	}

	public StatusPanel getMainStatusPanel() {
		return mainStatusPanel;
	}
	
}
