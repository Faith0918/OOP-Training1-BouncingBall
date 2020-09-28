package server;


import java.util.*;

public class ViewModel {
	private Map<String, List<ViewElement>>	map;
	
	
	public ViewModel() {
		map = new HashMap<String, List<ViewElement>>();
	}
	
	public void 	addViewElementGroup(String c) {
		map.put(c, new LinkedList<ViewElement>());
	}
	
	public Map<String, List<ViewElement>> getMap() {
		return map;
	}

	public void 	setViewElement(String color, int x, int y, int c, int i) {
		ViewElement	pos	=	new	ViewElement(x,y,c);
		map.get(color).set(i, pos);
	}
	
	public void 	addViewElement(String color, int x, int y, int c) {
		ViewElement	pos	=	new	ViewElement(x,y,c);
		map.get(color).add(pos);
		
	}
	
	public void removeViewElement(String c) {
		if(map.get(c).size()>0) {
			map.get(c).remove(0);
		}
	}
	
	public int 	getX(String c, int i) {
		return map.get(c).get(i).getX();
	}
	
	public int 	getY(String c, int i) {
		return map.get(c).get(i).getY();
	}
	
	public int 	getSize(String c) {
		return map.get(c).size();
	}

	public void addGroup(String groupName) {
		map.put(groupName, new LinkedList<ViewElement>());
		
	}

	public void removeGroup(String groupName) {
		map.remove(groupName);
		
	}
	
	

}
