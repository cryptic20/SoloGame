package main;

import javax.swing.JFrame;

import panel.GamePanel;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Test");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}
