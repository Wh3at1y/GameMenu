package game.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;

import game.view.GameFrame;

public class GameController
	{
		private GameFrame baseFrame;
		
		public GameController()
		{
			baseFrame = new GameFrame(this);
		}
		
		public void start()
		{
		    try 
		    {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/song.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } 
		    catch(Exception ex) 
		    {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }

		}
		
		public void navigateMenu(String disapearMenu, String showMenu)
		{
			if(disapearMenu.equals("mainMenu"))
				this.baseFrame.getGamePanel().getMainMenu().setVisible(false);
			if(disapearMenu.equals("optionsMenu"))
				this.baseFrame.getGamePanel().getOptionsMenu().setVisible(false);
			if(showMenu.equals("mainMenu"))
				this.baseFrame.getGamePanel().getMainMenu().setVisible(true);
			if(showMenu.equals("optionsMenu"))
				this.baseFrame.getGamePanel().getOptionsMenu().setVisible(true);
		}
		
		public void buttonListener(JLabel button)
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
					
					if (button == baseFrame.getGamePanel().getMainMenu().getExitButton())
					{
						System.exit(0);
					}
					else if(button == baseFrame.getGamePanel().getMainMenu().getOptionsButton())
					{
						navigateMenu("mainMenu", "optionsMenu");
					}
					else if(button == baseFrame.getGamePanel().getOptionsMenu().getBackButton())
					{
						navigateMenu("optionsMenu", "mainMenu");
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
				}

				public void mouseExited(MouseEvent e)
				{
					button.setEnabled(false);
				}

			});
		}
		public GameFrame getBaseFrame()
		{
			return baseFrame;
		}
	
	}
