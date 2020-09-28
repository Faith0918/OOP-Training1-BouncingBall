package server;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;


public class DrawComponent extends JComponent{
//	private	ViewModel	viewModel;
	private	LinkedList<ViewElement>		ballsView;
		
	
	public LinkedList<ViewElement> getBallsView() {
		return ballsView;
	}
	
	public void setBallsView(LinkedList<ViewElement> ballsView) {
		this.ballsView = ballsView;
	}
		
	
	
		public	DrawComponent() {
			ballsView = new LinkedList<ViewElement>();
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.white);
			g.fillRect(0, 0, 900, 800);
			for(ViewElement ball : ballsView) {
				
					
					g.setColor(new Color(ball.getColor()));
					g.fillOval(ball.getX()-10, ball.getY()-10, 20, 20);
				
			}
		}
	


		

		
	}

