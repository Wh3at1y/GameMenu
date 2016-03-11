package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class MainMenu extends JPanel
{
	private SpringLayout baseLayout;
	private JLabel startButton;
	private JLabel loadButton;
	private JLabel optionsButton;
	private JLabel exitButton;
	private JLabel ok;

	public MainMenu()
	{
		baseLayout = new SpringLayout();
		startButton = new JLabel("Start Game");
		loadButton = new JLabel("Load Save");
		optionsButton = new JLabel("Options");
		exitButton = new JLabel("Exit Game");

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
		
		ok = new JLabel("adwlkadlakwjdlakwjdlakdj");
		ok.setFont(new Font("Courier New", Font.BOLD, 20));
		ok.setVisible(false);
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
		add(ok);
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
	}

	private void buildListeners()
	{
		test(startButton);
		test(loadButton);
		test(optionsButton);
		test(exitButton);
	}

	private void test(JLabel button)
	{
		button.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{	
				try 
			    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Wh3at\\Downloads\\buttonClick.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			    } 
			    catch(Exception ex) 
			    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
			    }
				
				System.out.println("clicked start");
				if (button == exitButton)
				{
					System.exit(0);
				}
				else
				{
					setVisible(false);
				}
			}

			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e)
			{
				try 
			    {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Wh3at\\Downloads\\click.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			    } 
			    catch(Exception ex) 
			    {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
			    }
				
				button.setEnabled(true);
				button.setEnabled(true);

			}

			public void mouseExited(MouseEvent e)
			{
				button.setEnabled(false);
				button.setEnabled(false);

			}

		});
	}
}
