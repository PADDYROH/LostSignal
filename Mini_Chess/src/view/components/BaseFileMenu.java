package view.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.ExitListener;
import controller.FileMenuListener;


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
		addMenuListener(new FileMenuListener(mainFrame.getGUIModel()));
		registerMenuItem = new RegisterMenuItem(mainFrame);
		loginMenuItem = new LoginMenuItem(mainFrame);
		startMenuItem = new StartMenuItem(mainFrame);
		logoutWhiteMenuItem = new LogoutMenuItem(mainFrame, true);
		logoutBlackMenuItem = new LogoutMenuItem(mainFrame, false);
		swapMenuItem = new SwapMenuItem(mainFrame);
		
		exitMenuItem = new JMenuItem("Exit");
		// font
		exitMenuItem.addActionListener(new ExitListener());
		
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
