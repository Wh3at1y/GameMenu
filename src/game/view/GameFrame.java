package game.view;

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
			pack();
			this.setSize(1500,900);
			this.setVisible(true);
		}
		
		public GamePanel getGamePanel()
		{
			return basePanel;
		}
	}
