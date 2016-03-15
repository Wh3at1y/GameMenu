package game.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import game.controller.GameController;

public class GameFrame extends JFrame
	{
		private GamePanel basePanel;
		
		public GameFrame(GameController baseController)
		{
			basePanel = new GamePanel(baseController);
			buildFrame();
		}
		
		private void buildFrame()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(basePanel);
			setSize(1200,700);
			this.setVisible(true);
		}
		
		public GamePanel getGamePanel()
		{
			return basePanel;
		}
	}
