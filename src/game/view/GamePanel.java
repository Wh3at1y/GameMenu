package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GamePanel extends JPanel
	{
		private SpringLayout baseLayout;
		private JLabel backgroundImage;
		private JLabel startButton;
		private JLabel loadButton;
		private JLabel optionsButton;
		private JLabel exitButton;
		
		public GamePanel()
		{
			baseLayout = new SpringLayout();
			backgroundImage = new JLabel();
			startButton = new JLabel("Start Game");
			loadButton = new JLabel("Load Save");
			baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 18, SpringLayout.SOUTH, startButton);
			baseLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, startButton);
			optionsButton = new JLabel("Options");
			baseLayout.putConstraint(SpringLayout.NORTH, optionsButton, 16, SpringLayout.SOUTH, loadButton);
			baseLayout.putConstraint(SpringLayout.WEST, optionsButton, 0, SpringLayout.WEST, startButton);
			exitButton = new JLabel("Exit Game");
			baseLayout.putConstraint(SpringLayout.NORTH, exitButton, 16, SpringLayout.SOUTH, optionsButton);
			baseLayout.putConstraint(SpringLayout.EAST, exitButton, 0, SpringLayout.EAST, loadButton);
			baseLayout.putConstraint(SpringLayout.NORTH, startButton, 111, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, startButton, 128, SpringLayout.WEST, this);
			startButton.setFont(new Font("Courier New", Font.BOLD, 16));
			loadButton.setFont(new Font("Courier New", Font.BOLD, 16));
			loadButton.setForeground(Color.WHITE);
			optionsButton.setFont(new Font("Courier New", Font.BOLD, 16));
			optionsButton.setForeground(Color.WHITE);
			exitButton.setFont(new Font("Courier New", Font.BOLD, 16));
			exitButton.setForeground(Color.WHITE);
			exitButton.setEnabled(false);
			optionsButton.setEnabled(false);
			loadButton.setEnabled(false);
			startButton.setEnabled(false);
			startButton.setForeground(Color.WHITE);
			backgroundImage.setPreferredSize(new Dimension(600,500));
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
			add(backgroundImage);
		}
		
		private void buildWindow()
		{
			backgroundImage.setVerticalAlignment(SwingConstants.CENTER);
			backgroundImage.setHorizontalAlignment(SwingConstants.CENTER);
			backgroundImage.setIcon(new ImageIcon(GamePanel.class.getResource("/game/view/colorwave.gif")));
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
							System.out.println("clicked start");
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
