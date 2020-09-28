package server;

import java.util.LinkedList;

public class ServerCore {
	private	BallView	ballView;
	private	BallManager	balls;
	private	ServerSocketConnector	listener;

	
	public ServerCore() {
		ballView = new BallView();
		balls = new BallManager();
		listener = new ServerSocketConnector(this);
		ballView.setVisible();

	}
	
	public static void main(String[] args) {
		ServerCore core = new ServerCore();
		core.listener.start();
		core.start();
		
	}
	
	private void start() {
		
		while(true) {
			moveBall();
			reflectBall();
			drawBall();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void drawBall() {
		renewViewElementList();
		ballView.repaint();
	}
	private void renewViewElementList() {
		ballView.deleteAllballsView();
		LinkedList<String> groupNames = getGroupNames();
		for(String name : groupNames) {
			for(Ball ball : balls.getGroup(name).getBallList()){
				ballView.addViewElement(ball.getX(), ball.getY(), balls.getGroup(name).getColor());
			}
		}
		
	}

	public void moveBall() {
		
		for(String i : balls.getMap().keySet()) {
			if(balls.isMove(i)) {
				for(int j = 0; j<balls.getGroupSize(i); ++j) {
					if(balls.getBall(i, j).isRight()) {
						balls.getBall(i, j).setX(balls.getBall(i, j).getX()+1);
					}else {
						balls.getBall(i, j).setX(balls.getBall(i, j).getX()-1);
					}
					if(balls.getBall(i, j).isDown()) {
						balls.getBall(i, j).setY(balls.getBall(i, j).getY()-1);
					}else {
						balls.getBall(i, j).setY(balls.getBall(i, j).getY()+1);
					}
					
				}
			}
		}
	}
	public void reflectBall() {
		for(String i : balls.getMap().keySet()) {
				for(int j = 0; j<balls.getGroupSize(i); ++j) {
					if(balls.getBall(i, j).getX()<0 || balls.getBall(i, j).getX()>900) {
						balls.getBall(i, j).setRight(!balls.getBall(i, j).isRight());

					}
					if(balls.getBall(i, j).getY()<0 || balls.getBall(i, j).getY()>800) {
						balls.getBall(i, j).setDown(!balls.getBall(i, j).isDown());
					
					}
				}
		}
	}

	public void startMove(String color) {
		balls.setMove(color, true);
		
	}

	public void stopMove(String color) {
		balls.setMove(color, false);
	}

	public void addBall(String color) {
		
		Ball	ball = new Ball();
		ball.setDown(true);
		ball.setRight(true);
		ball.setX(0);
		ball.setY(0);
		balls.addBall(color, ball);
		
	}

	public void removeBall(String color) {
		
		balls.removeBall(color);
		
	}

	public void addGroup(String newGroupName, String newGroupColor) {
		
		balls.addGroup(newGroupName, newGroupColor);
		
		listener.send(getGroupNames());
		
	}
	
	public void removeGroup(String color) {
		
		balls.removeGroup(color);
		listener.send(getGroupNames());
		
	}

	public LinkedList<String> getGroupNames() {
		Object [] keys = balls.getMap().keySet().toArray();
		LinkedList<String> groupNames= new LinkedList<String>();
		int mapSize = balls.getMap().size();
		int index = 0;
		for(Object key:keys) {
			if(index<mapSize) {
				groupNames.add(key.toString());
				index = index + 1;
			}	
		}
		
		return groupNames;
		
	}


	
	

	
		
	}

