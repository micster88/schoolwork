package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Triangle Drawing
class Triangle extends Shape{
	String pointSide;
	int x1;
	int y1;
	int x2;
	int y2;
	Line l1;
	Line l2;
	Line l3;
	
	//Constructor
	protected Triangle(int x, int y, String pointSide, int height, int width, SimpleDrawing draw) {
		super(x, y, draw);
		this.pointSide=pointSide;
		//IF the Point is up
		if(pointSide=="Up" || pointSide=="UP" || pointSide=="up"){//Up!
			y2=y+height;
			y1=y+height;
			x1=x-(width/2);
			x2=x+(width/2);
		//If the Point is Down
		}else if(pointSide=="Down" || pointSide=="DOWN" || pointSide=="down"){//Down!
			y2=y-height;
			y1=y-height;
			x1=x-(width/2);
			x2=x+(width/2);
		//If the point is right
		}else if(pointSide=="Right"|| pointSide=="RIGHT" || pointSide=="right"){//Right!
			x1=x-width;
			x2=x-width;
			y1=y-(height/2);
			y2=y+(height/2);
		//if the point is left
		}else if(pointSide=="Left" || pointSide=="LEFT" || pointSide=="left"){
			x1=x+width;
			x2=x+width;
			y1=y-(height/2);
			y2=y+(height/2);
		}
		draw();
	}
	
	//Draws the triangle
	@Override
	protected void draw(){
		l1=new Line(x, y, x2, y2, draw);
		l2=new Line(x2, y2, x1, y1, draw);
		l3=new Line(x1, y1, x, y, draw);
	}
	
	//erases the triangle
	@Override
	protected void erase(){
		l1.erase();
		l2.erase();
		l3.erase();
	}
	
	//Checks the point clicked depending on the type
	@Override
	protected boolean checkPoint(int pX, int pY){
		if(pointSide=="Up" || pointSide=="UP" || pointSide=="up"){//Up!
			if(((x1<pX && pX<x2)||pX==x1||pX==x2)&&((y<pY && pY<y2)||pY==y||pY==y2)){
				return true;
			}
			return false;
		}else if(pointSide=="Down" || pointSide=="DOWN" || pointSide=="down"){//Down!
			if(((x1<pX && pX<x2)||pX==x1||pX==x2)&&((y1<pY && pY<y)||pY==y1||pY==y)){
				return true;
			}
			return false;
		}else if(pointSide=="Right"|| pointSide=="RIGHT" || pointSide=="right"){//Right!
			if(((x1<pX && pX<x)||pX==x1||pX==x)&&((y1<pY && pY<y2)||pY==y1||pY==y2)){
				return true;
			}
			return false;
		}else if(pointSide=="Left" || pointSide=="LEFT" || pointSide=="left"){
			if(((x<pX && pX<x2)||pX==x2||pX==x)&&((y1<pY && pY<y2)||pY==y1||pY==y2)){
				return true;
			}
			return false;
		}
		return false;
	}
	
}