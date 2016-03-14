package game.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import game.controller.GameController;

public class OptionsMenu extends JPanel
{
	private GameController baseController;
	private SpringLayout baseLayout;
	private JLabel changeUserNameButton;
	private JLabel backButton;
	private JTextField enterUserName;
	private JLabel toggleClicksButton;
	private JLabel toggleMusicButton;
	
	private String buttonStatus = "On";
	private String musicStatus = "On";
	
	public OptionsMenu(GameController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		backButton = new JLabel("Back");
		backButton.setFont(new Font("Courier New", Font.BOLD, 20));
		backButton.setEnabled(false);
		backButton.setForeground(Color.WHITE);
		
		changeUserNameButton = new JLabel("Change Username");
		changeUserNameButton.setFont(new Font("Courier New", Font.BOLD, 20));
		changeUserNameButton.setEnabled(false);
		changeUserNameButton.setForeground(Color.WHITE);
		
		enterUserName = new JTextField();
		
		toggleClicksButton = new JLabel("Toggle button clicks : Clicks ");
		toggleClicksButton.setFont(new Font("Courier New", Font.BOLD, 20));
		toggleClicksButton.setEnabled(false);
		toggleClicksButton.setForeground(Color.WHITE);
		
		toggleMusicButton = new JLabel();
		toggleMusicButton.setFont(new Font("Courier New", Font.BOLD, 20));
		toggleMusicButton.setEnabled(false);
		toggleMusicButton.setForeground(Color.WHITE);
		
		setVisible(false);
		setOpaque(false);
				
		setMusicText(musicStatus);
		setButtonClicksText(buttonStatus);
		buildPanel();
		buildPlacements();
		buildListeners();
	}
	
	private void buildPanel()
	{
		setLayout(baseLayout);
		add(backButton);
		add(changeUserNameButton);
		add(enterUserName);
		add(toggleClicksButton);
		add(toggleMusicButton);
	}
	
	private void buildPlacements()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, backButton, 28, SpringLayout.SOUTH, toggleMusicButton);
		baseLayout.putConstraint(SpringLayout.NORTH, toggleMusicButton, 19, SpringLayout.SOUTH, toggleClicksButton);
		baseLayout.putConstraint(SpringLayout.WEST, toggleMusicButton, 0, SpringLayout.WEST, backButton);
		baseLayout.putConstraint(SpringLayout.NORTH, toggleClicksButton, 18, SpringLayout.SOUTH, enterUserName);
		baseLayout.putConstraint(SpringLayout.WEST, toggleClicksButton, 0, SpringLayout.WEST, backButton);
		baseLayout.putConstraint(SpringLayout.WEST, enterUserName, 16, SpringLayout.EAST, changeUserNameButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, enterUserName, -749, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, enterUserName, -1016, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, changeUserNameButton, 2, SpringLayout.NORTH, enterUserName);
		baseLayout.putConstraint(SpringLayout.WEST, changeUserNameButton, 0, SpringLayout.WEST, backButton);
		baseLayout.putConstraint(SpringLayout.WEST, backButton, 129, SpringLayout.WEST, this);
	}
	
	private void buildListeners()
	{
		baseController.buttonListener(backButton);
		baseController.buttonListener(changeUserNameButton);
		baseController.buttonListener(toggleClicksButton);
		baseController.buttonListener(toggleMusicButton);
	}
	
	public JLabel getBackButton()
	{
		return backButton;
	}
	
	public JLabel getUserNameButton()
	{
		return changeUserNameButton;
	}
	
	public String getUserNameText()
	{
		return enterUserName.getText();
	}
	
	public JLabel getMusicButton()
	{
		return toggleMusicButton;
	}
	
	public JLabel getClicksButton()
	{
		return toggleClicksButton;
	}
	
	public void setMusicText(String status)
	{
		this.musicStatus = status;
		toggleMusicButton.setText("Toggle music : Music " + status);
	}
	
	public String getStatus()
	{
		return musicStatus;
	}
	
	public void setButtonClicksText(String status)
	{
		this.buttonStatus = status;
		toggleClicksButton.setText("Toggle button clicks : Clicks " + status);
	}
	public String getButtonStatus()
	{
		return buttonStatus;
	}
}
