package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Arrow Class
class Arrow extends Shape {
	private Line l1;
	private Line l2;
	private Line l3;
	private int x1;
	private int y1;
	
	//Constructor
	protected Arrow(int x, int y, int x1, int y1, SimpleDrawing draw) {
		super(x, y, draw);
		this.x1=x1;
		this.y1=y1;
		draw();
	}
	
	//Draws the Arrow, Algorithm had help from Kevin Dorsett
	@Override
	protected void draw(){
		int width=x1-x;
		int height=y1-y;
		int xDist=width/10;
		int yDist=height/10;
		int nX=x1-xDist;
		int nY=y1-yDist;
		l1=new Line(x,y,x1,y1,draw);
		l2=new Line(x1,y1,nX+yDist,nY-xDist,draw);
		l3=new Line(x1,y1,nX-yDist,nY+xDist,draw);
	}
	
	//Erases the Arrow
	@Override
	protected void erase(){
		l1.erase();
		l2.erase();
		l3.erase();
	}

	//Checks the Point by checking each line
	@Override
	protected boolean checkPoint(int pX, int pY){
		if(l1.checkPoint(pX, pY)==true){
			return true;
		}
		else if(l2.checkPoint(pX, pY)==true){
			return true;
		}
		else if(l3.checkPoint(pX, pY)==true){
			return true;
		}
		return false;
	}
}