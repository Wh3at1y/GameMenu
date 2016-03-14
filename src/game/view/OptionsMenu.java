package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import game.controller.GameController;

public class OptionsMenu extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private JLabel backButton;
	
	public OptionsMenu(GameController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		backButton = new JLabel("Back");
		backButton.setFont(new Font("Courier New", Font.BOLD, 20));
		backButton.setEnabled(false);
		backButton.setForeground(Color.WHITE);
		this.setOpaque(false);
		
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		add(backButton);
	}
	
	private void buildPlacements()
	{
	}
	
	private void buildListeners()
	{
		baseController.buttonListener(backButton);
	}
	
	public JLabel getBackButton()
	{
		return backButton;
	}
}
