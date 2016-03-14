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
	
	public GamePanel(GameController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(MainMenu.class.getResource("/colorwave.gif")));
		mainMenu = new MainMenu(baseController);
		optionsMenu = new OptionsMenu(baseController);
		baseLayout.putConstraint(SpringLayout.NORTH, optionsMenu, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, optionsMenu, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, optionsMenu, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, optionsMenu, 0, SpringLayout.EAST, this);
		optionsMenu.setVisible(false);
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		
		add(mainMenu);
		add(optionsMenu);
		add(backgroundImage);
	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, mainMenu, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, mainMenu, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, mainMenu, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, mainMenu, 0, SpringLayout.EAST, this);
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
