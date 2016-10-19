package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Super Class for all Shapes
class Shape {
	protected int x;
	protected int y;
	protected SimpleDrawing draw;
	
	//The Super Constructor saying all shapes need a point and Simple Drawning
	protected Shape(int x, int y, SimpleDrawing draw){
		this.x=x;
		this.y=y;
		this.draw=draw;
	}
	
	//Erase Function to be overridden
	protected void erase(){	}
	
	//Draw Function to be overridden
	protected void draw(){ }
	
	//Check Function Function to be overridden
	protected boolean checkPoint(int pX, int pY){
		return false;
	}
}
