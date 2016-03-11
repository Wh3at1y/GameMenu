package game.view;

import javax.swing.*;

import game.controller.GameController;

public class OptionsMenu extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private JLabel ok;
	
	public OptionsMenu()
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		ok = new JLabel("OKOK");
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		add(ok);
	}
	
	private void buildPlacements()
	{
	}
	
	private void buildListeners()
	{
		
	}
}
