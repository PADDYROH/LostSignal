package view.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.ExitListener;
import controller.FileMenuListener;
import view.model.GUIModel;


public class BaseFileMenu extends JMenu {

	private JMenuItem exitMenuItem;
	private BaseFrame mainFrame;
	private RegisterMenuItem registerMenuItem;
	

	private LoginMenuItem loginMenuItem;
	private StartMenuItem startMenuItem;
	private LogoutMenuItem logoutWhiteMenuItem;
	private LogoutMenuItem logoutBlackMenuItem;
	private SwapMenuItem swapMenuItem;

	public BaseFileMenu(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("File");
		this.mainFrame = mainFrame;
		// set font?
		setFont(GUIModel.normalFont);
		addMenuListener(new FileMenuListener(mainFrame.getGUIModel()));
		registerMenuItem = new RegisterMenuItem(mainFrame);
		registerMenuItem.setFont(GUIModel.normalFont);
		
		loginMenuItem = new LoginMenuItem(mainFrame);
		loginMenuItem.setFont(GUIModel.normalFont);
		
		startMenuItem = new StartMenuItem(mainFrame);
		startMenuItem.setFont(GUIModel.normalFont);
		
		logoutWhiteMenuItem = new LogoutMenuItem(mainFrame, true);
		logoutWhiteMenuItem.setFont(GUIModel.normalFont);
		
		logoutBlackMenuItem = new LogoutMenuItem(mainFrame, false);
		logoutBlackMenuItem.setFont(GUIModel.normalFont);
		
		swapMenuItem = new SwapMenuItem(mainFrame);
		swapMenuItem.setFont(GUIModel.normalFont);
		
		exitMenuItem = new JMenuItem("Exit");
		// font
		exitMenuItem.addActionListener(new ExitListener());
		exitMenuItem.setFont(GUIModel.normalFont);
		
		add(startMenuItem);
		add(loginMenuItem);
		add(registerMenuItem);
		add(swapMenuItem);
		add(logoutWhiteMenuItem);
		add(logoutBlackMenuItem);
		add(exitMenuItem);
	
	}

	public RegisterMenuItem getRegisterMenuItem() {
		return registerMenuItem;
	}

	public LoginMenuItem getLoginMenuItem() {
		return loginMenuItem;
	}

	public StartMenuItem getStartMenuItem() {
		return startMenuItem;
	}

	public LogoutMenuItem getLogoutWhiteMenuItem() {
		return logoutWhiteMenuItem;
	}

	public LogoutMenuItem getLogoutBlackMenuItem() {
		return logoutBlackMenuItem;
	}

	public SwapMenuItem getSwapMenuItem() {
		return swapMenuItem;
	}

}
