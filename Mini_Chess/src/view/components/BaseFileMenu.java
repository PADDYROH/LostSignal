package view.components;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.ExitListener;


public class BaseFileMenu extends JMenu {

	private JMenuItem exitMenuItem;
	private BaseFrame mainFrame;
	private RegisterMenuItem registerMenuItem;
	private LoginMenuItem loginMenuItem;
	private StartMenuItem startMenuItem;
	private LogoutMenuItem logoutWhiteMenuItem;
	private LogoutMenuItem logoutBlackMenuItem;

	public BaseFileMenu(BaseFrame mainFrame) {
		// TODO Auto-generated constructor stub
		super("File");
		this.mainFrame = mainFrame;
		// set font?
		
		registerMenuItem = new RegisterMenuItem(mainFrame);
		loginMenuItem = new LoginMenuItem(mainFrame);
		startMenuItem = new StartMenuItem(mainFrame);
		logoutWhiteMenuItem = new LogoutMenuItem(mainFrame, true);
		logoutBlackMenuItem = new LogoutMenuItem(mainFrame, false);
		
		exitMenuItem = new JMenuItem("Exit");
		// font
		exitMenuItem.addActionListener(new ExitListener());
		
		add(startMenuItem);
		add(loginMenuItem);
		add(registerMenuItem);
		add(logoutWhiteMenuItem);
		add(logoutBlackMenuItem);
		add(exitMenuItem);
		
		
	}

	

}
