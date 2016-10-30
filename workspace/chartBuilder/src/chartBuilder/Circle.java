package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Circle Class
class Circle extends Shape{
	private int size;
	
	//Constructor
	protected Circle(int size, int x, int y, SimpleDrawing draw){
		super(x,y,draw);
		this.size=size;
		draw();
	}
	
	//Draws the Circle, Uses an Algorithm from CSCI 348 Graphics
	@Override
	protected void draw(){
		double inc=2.0*Math.PI / 3000000.0;
	    for (double theta = 0; theta <2*Math.PI; theta += inc){
	    	int compX=(int)(x+size*Math.cos(theta));
	    	int compY=(int)(y+size*Math.sin(theta));
	        draw.showPoint(compX, compY);
	    }
	}
	
	//Erases the Circle
	@Override
	protected void erase(){
		double inc=2.0*Math.PI / 30000.0;
	    for (double theta = 0; theta <2*Math.PI; theta += inc){
	    	int compX=(int)(x+size*Math.cos(theta));
	    	int compY=(int)(y+size*Math.sin(theta));
	        draw.hidePoint(compX, compY);
	    }
	}
	
	//Checks the point if it is width a square around the circle
	@Override
	protected boolean checkPoint(int pX, int pY){
		int x1=x-size;
		int x2=x+size;
		int y1=y-size;
		int y2=y+size;
		if(((x1<pX && pX<x2)||pX==x1||pX==x2)&&((y1<pY && pY<y2)||pY==y1||pY==y2)){
			return true;
		}
		return false;
	}
}