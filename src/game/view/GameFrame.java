package game.view;

import javax.swing.JFrame;

public class GameFrame extends JFrame
	{
		private GamePanel basePanel;
		public GameFrame()
		{
			basePanel = new GamePanel();
			buildFrame();
		}
		
		private void buildFrame()
		{
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(basePanel);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.setUndecorated(true);
			this.setVisible(true);
		}
	}
