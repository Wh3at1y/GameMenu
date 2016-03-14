package game.view;

import javax.swing.*;

import game.controller.GameController;

public class GamePanel extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private MainMenu mainMenu;
	private OptionsMenu optionsMenu;
	private JLabel backgroundImage;
	private JLabel logo;
	
	public GamePanel(GameController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		mainMenu = new MainMenu(baseController);
		optionsMenu = new OptionsMenu(baseController);
		backgroundImage = new JLabel();
		logo = new JLabel();
		
		setIcons();
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	private void setIcons()
	{
		backgroundImage.setIcon(new ImageIcon(MainMenu.class.getResource("/colorwave.gif")));
		logo.setIcon(new ImageIcon(GamePanel.class.getResource("/logo.png")));
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		
		add(mainMenu);
		add(optionsMenu);
		add(logo);
		add(backgroundImage);
	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, mainMenu, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, mainMenu, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, mainMenu, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, mainMenu, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, optionsMenu, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, optionsMenu, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, optionsMenu, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, optionsMenu, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, logo, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, logo, 67, SpringLayout.WEST, this);
	}
	
	private void buildListeners()
	{
		
	}
	
	public MainMenu getMainMenu()
	{
		return mainMenu;
	}
	
	public OptionsMenu getOptionsMenu()
	{
		return optionsMenu;
	}
}
