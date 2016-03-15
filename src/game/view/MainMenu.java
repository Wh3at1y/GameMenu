package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import game.controller.GameController;

public class MainMenu extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private JLabel startButton;
	private JLabel loadButton;
	private JLabel optionsButton;
	private JLabel exitButton;
	private JLabel showUserName;

	public MainMenu(GameController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		startButton = new JLabel("Start Game");
		loadButton = new JLabel("Load Profile");
		optionsButton = new JLabel("Options");
		exitButton = new JLabel("Exit Game");
		showUserName = new JLabel("Username: " );

		startButton.setFont(new Font("Courier New", Font.BOLD, 20));
		startButton.setEnabled(false);
		startButton.setForeground(Color.WHITE);

		loadButton.setFont(new Font("Courier New", Font.BOLD, 20));
		loadButton.setForeground(Color.WHITE);
		loadButton.setEnabled(false);

		optionsButton.setFont(new Font("Courier New", Font.BOLD, 20));
		optionsButton.setForeground(Color.WHITE);
		optionsButton.setEnabled(false);

		exitButton.setFont(new Font("Courier New", Font.BOLD, 20));
		exitButton.setForeground(Color.WHITE);
		exitButton.setEnabled(false);
		
		showUserName.setFont(new Font("Courier New", Font.BOLD, 20));
		showUserName.setForeground(Color.WHITE);
		
		this.setOpaque(false);
		
		buildPanel();
		buildWindow();
		buildListeners();
	}

	private void buildPanel()
	{
		setLayout(baseLayout);

		add(startButton);
		add(loadButton);
		add(optionsButton);
		add(exitButton);
		add(showUserName);
	}

	private void buildWindow()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, exitButton, 16, SpringLayout.SOUTH, optionsButton);
		baseLayout.putConstraint(SpringLayout.EAST, exitButton, 0, SpringLayout.EAST, loadButton);
		baseLayout.putConstraint(SpringLayout.NORTH, startButton, 111, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, startButton, 128, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, optionsButton, 16, SpringLayout.SOUTH, loadButton);
		baseLayout.putConstraint(SpringLayout.WEST, optionsButton, 0, SpringLayout.WEST, startButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 18, SpringLayout.SOUTH, startButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, startButton);
		baseLayout.putConstraint(SpringLayout.NORTH, showUserName, 46, SpringLayout.SOUTH, exitButton);
		baseLayout.putConstraint(SpringLayout.WEST, showUserName, 0, SpringLayout.WEST, startButton);
	}

	private void buildListeners()
	{
		baseController.buttonListener(startButton);
		baseController.buttonListener(loadButton);
		baseController.buttonListener(optionsButton);
		baseController.buttonListener(exitButton);
	}
	
	public JLabel getExitButton()
	{
		return exitButton;
	}
	
	public JLabel getOptionsButton()
	{
		return optionsButton;
	}
	
	public void setUserNameText(String updatedUserName)
	{
		showUserName.setText("Username: " + updatedUserName);
	}
}
