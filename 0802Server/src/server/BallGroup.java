package server;

import java.util.*;



public class BallGroup {
	private	List<Ball>			listBall;
	private	int					color;
	private	boolean				move = false;
	
	public	BallGroup(int	color) {
		listBall = new LinkedList<Ball>();
		this.color = color;
		
	}
	

	public	List<Ball>	getBallList(){
		return	listBall;
	}	
	
	public	void		setBall(int index, Ball ball) {
		listBall.set(index, ball);	
	}
	
	public	void		addBall(Ball	ball) {
		listBall.add(ball);	
	}
	
	public	void		removeBall() {
		listBall.remove(0);
	}
	
	public int 			getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public	boolean		isMove() {
		return	move;
	}
	
	public	void		setMove(boolean b) {
		move = b;
	}
	

	
}	
