package server;

import java.util.LinkedList;

import javax.swing.JFrame;



public class BallView extends JFrame{
	private JFrame	frame;
	private	DrawComponent	cmp;
	
	public	BallView() {
		frame = new JFrame();
		cmp = new DrawComponent();
		frame.setSize(900, 800);
		frame.add(cmp);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	


	public void setVisible() {
		frame.setVisible(true);
	}

//	public ViewModel getViewModel() {
//		return cmp.getViewModel();
//	}

	public void repaint() {
		cmp.repaint();
	}





	public void addViewElement(int x, int y, int c) {
		ViewElement e = new ViewElement(x, y, c);
		LinkedList<ViewElement> l = new LinkedList<ViewElement>();
		l = cmp.getBallsView();
		l.add(e);
		cmp.setBallsView(l);
	}



	public void deleteAllballsView() {
		LinkedList<ViewElement> l = new LinkedList<ViewElement>();
		cmp.setBallsView(l);
		
	}



	


}
