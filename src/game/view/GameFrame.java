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
			this.setResizable(false);
			this.setTitle("Guessing Game");
			this.setContentPane(basePanel);
			this.pack();
			this.setSize(600,500);
			this.setVisible(true);
		}
	}
