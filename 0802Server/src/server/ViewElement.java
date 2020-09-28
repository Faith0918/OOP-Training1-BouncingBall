package server;

public class ViewElement {
	private		int color;
	private		int x;
	private		int y;
	
	public	ViewElement(int x, int y, int color) {
		this.x=x;
		this.y=y;
		this.color=color;

	}
	
	public	void	setPosition(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color=color;
	}
	public	int		getX() {
		return x;
	}
	public	int 	getY() {
		return y;
	}
	public int getColor() {
		return color;
	}
}
