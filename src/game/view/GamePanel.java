package game.view;

import javax.swing.*;

import game.controller.GameController;

public class GamePanel extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private MainMenu mainMenu;
	private JLabel backgroundImage;
	
	public GamePanel()
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		mainMenu = new MainMenu();
		backgroundImage = new JLabel();
		backgroundImage.setSize(JFrame.MAXIMIZED_BOTH, JFrame.MAXIMIZED_BOTH);
		baseLayout.putConstraint(SpringLayout.NORTH, mainMenu, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, mainMenu, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, mainMenu, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, mainMenu, 0, SpringLayout.EAST, this);
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		add(backgroundImage);
		add(mainMenu);
	}
	
	private void buildPlacements()
	{
		backgroundImage.setIcon(new ImageIcon(MainMenu.class.getResource("/game/view/colorwave.gif")));
	}
	
	private void buildListeners()
	{
		
	}
}
