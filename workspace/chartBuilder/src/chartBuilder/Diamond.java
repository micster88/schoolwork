package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Diamond
class Diamond extends Shape{
	int x1;
	int y1;
	int x2;
	int y2;
	Line l1;
	Line l2;
	Line l3;
	Line l4;
	//Constructor
	protected Diamond(int x, int y, int width, int height, SimpleDrawing draw){
		super(x,y,draw);
		x1=x-(width/2);
		x2=x+(width/2);
		y1=y-(height/2);
		y2=y+(height/2);
		draw();
	}
	//Draws the Diamond
	@Override
	protected void draw(){
		l1=new Line(x1,y,x,y1, draw);
		l2=new Line(x,y1,x2,y, draw);
		l3=new Line(x2,y,x,y2, draw);
		l4=new Line(x,y2,x1,y, draw);
	}
	
	//Erases the Diamond
	@Override
	protected void erase(){
		l1.erase();
		l2.erase();
		l3.erase();
		l4.erase();
	}
	
	//Checks the Point of in a box around the diamond
	@Override
	protected boolean checkPoint(int pX, int pY){
		if(((x1<pX && pX<x2)||pX==x1||pX==x2)&&((y1<pY && pY<y2)||pY==y1||pY==y2)){
			return true;
		}
		return false;
	}
}
