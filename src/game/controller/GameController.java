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
		private Clip musicClip;
		private Clip buttonClip;
		private Clip clickClip;

		public GameController()
			{
				baseFrame = new GameFrame(this);
			}

		public void start()
			{
				try
					{
						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/song.wav").getAbsoluteFile());
						musicClip = AudioSystem.getClip();
						musicClip.open(audioInputStream);
						musicClip.start();
					}
				catch (Exception ex)
					{
						System.out.println("Error with playing sound.");
						ex.printStackTrace();
					}

			}

		public void navigateMenu(String disapearMenu, String showMenu)
			{
				if (disapearMenu.equals("mainMenu"))
					this.baseFrame.getGamePanel().getMainMenu().setVisible(false);
				if (disapearMenu.equals("optionsMenu"))
					this.baseFrame.getGamePanel().getOptionsMenu().setVisible(false);
				if (showMenu.equals("mainMenu"))
					this.baseFrame.getGamePanel().getMainMenu().setVisible(true);
				if (showMenu.equals("optionsMenu"))
					this.baseFrame.getGamePanel().getOptionsMenu().setVisible(true);
			}

		public void buttonListener(JLabel button)
			{
				button.addMouseListener(new MouseListener()
					{
						public void mouseClicked(MouseEvent e)
							{
								if (baseFrame.getGamePanel().getOptionsMenu().getButtonStatus().equals("On"))
									{
										try
											{
												AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/buttonClick.wav").getAbsoluteFile());
												buttonClip = AudioSystem.getClip();
												buttonClip.open(audioInputStream);
												buttonClip.start();
											}
										catch (Exception ex)
											{
												System.out.println("Error with playing sound.");
												ex.printStackTrace();
											}
									}
								else
									buttonClip.stop();

								if (button == baseFrame.getGamePanel().getMainMenu().getExitButton())
									{
										System.exit(0);
									}
								else if (button == baseFrame.getGamePanel().getMainMenu().getOptionsButton())
									{
										navigateMenu("mainMenu", "optionsMenu");
									}
								else if (button == baseFrame.getGamePanel().getOptionsMenu().getUserNameButton() || button == baseFrame.getGamePanel().getOptionsMenu().getBackButton())
									{
										String userName = baseFrame.getGamePanel().getOptionsMenu().getUserNameText();
										baseFrame.getGamePanel().getMainMenu().setUserNameText(userName);
										navigateMenu("optionsMenu", "mainMenu");
									}
								else if (button == baseFrame.getGamePanel().getOptionsMenu().getMusicButton())
									{
										if (baseFrame.getGamePanel().getOptionsMenu().getStatus().equals("On"))
											{
												musicClip.stop();
												baseFrame.getGamePanel().getOptionsMenu().setMusicText("Off");
											}
										else
											{
												musicClip.start();
												baseFrame.getGamePanel().getOptionsMenu().setMusicText("On");
											}
									}
								else if (button == baseFrame.getGamePanel().getOptionsMenu().getClicksButton())
									{
										if (baseFrame.getGamePanel().getOptionsMenu().getButtonStatus().equals("On"))
											{
												buttonClip.stop();
												baseFrame.getGamePanel().getOptionsMenu().setButtonClicksText("Off");
											}
										else
											{
												buttonClip.start();
												baseFrame.getGamePanel().getOptionsMenu().setButtonClicksText("On");
											}
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
								if (baseFrame.getGamePanel().getOptionsMenu().getButtonStatus().equals("On"))
									{
										try
											{
												AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/click.wav").getAbsoluteFile());
												clickClip = AudioSystem.getClip();
												clickClip.open(audioInputStream);
												clickClip.start();
											}
										catch (Exception ex)
											{
												System.out.println("Error with playing sound.");
												ex.printStackTrace();
											}
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
