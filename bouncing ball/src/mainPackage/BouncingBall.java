package mainPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BouncingBall extends JComponent implements ActionListener{
	
	//VARIABLES
	int ballX = 400;
	int ballY = 100;
	double ballYSpeed = 7;
	double gravity = 1;
	
	//MAIN FUNCTION
	public static void main(String[] args){
		
		JFrame window = new JFrame("Bouncing ball");
		BouncingBall game = new BouncingBall();
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		Timer t = new Timer(30, game);
		t.start();
		
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	
	//GRAPHICS
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.BLUE);
		g.fillOval(ballX, ballY , 30, 30);
	}
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		ballY = (int) (ballY + ballYSpeed);
		ballYSpeed += gravity;
		
		if (ballY >= 600-30){
			ballYSpeed = -0.8 * ballYSpeed;
		}
		repaint();
	}
}
