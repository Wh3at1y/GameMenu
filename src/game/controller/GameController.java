package game.controller;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import game.view.GameFrame;

public class GameController
	{
		private GameFrame baseFrame;
		
		public GameController()
		{
			baseFrame = new GameFrame();
		}
		public void start()
		{
		    try 
		    {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Wh3at\\Downloads\\song.wav").getAbsoluteFile());
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
	}
