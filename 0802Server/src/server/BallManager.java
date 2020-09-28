package server;

import java.util.HashMap;
import java.util.Map;



public class BallManager {

private	Map<String, BallGroup>		map;
	
	public	BallManager() {
		map	=	new	HashMap<String,BallGroup>();
		map.put("RED", new BallGroup(0xFF0000));
		map.put("GREEN", new BallGroup(0x00FF00));
		map.put("BLUE", new BallGroup(0x0000FF));
	}
	
	
	
	
	
	
	public	Map<String,BallGroup>	getMap(){
		return	map;
	}
	
	public BallGroup				getGroup(String c) {
		return	map.get(c);
	}
	public	int					getGroupSize(String c){
		return	map.get(c).getBallList().size();
	}
	
	public Ball					getBall(String c, int index) {
		return	map.get(c).getBallList().get(index);
	}
	
	public	void				setBall(String c, int index, Ball ball) {
		map.get(c).getBallList().set(index, ball);
	}
	
	public	void				addBall(String	c, Ball ball) {
		map.get(c).addBall(ball);
	}
	
	public	void				removeBall(String c) {
		if(map.get(c).getBallList().size()>0) {
			map.get(c).removeBall();
		}	
	}
	
	public	boolean				isMove(String	c) {
		return	map.get(c).isMove();
	}
	
	public	void				setMove(String c, boolean	b) {
		map.get(c).setMove(b);
	}






	public void addGroup(String groupName, String groupColor) {
		int color = Integer.parseInt(groupColor);
		map.put(groupName, new BallGroup(color));
		
	}






	public void removeGroup(String groupName) {
		map.remove(groupName);
		
	}
	
}