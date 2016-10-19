package chartBuilder;

import csci348.drawings.SimpleDrawing;

//Square Class
class Square extends Shape {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	// Constructor that takes the Command of the Mid-Point and, Width and Height
	protected Square(int x, int y, int width, int height, SimpleDrawing draw) {
		super(x,y, draw);
		this.x1 = x - (width / 2);
		this.y1 = y - (height / 2);
		this.x2 = x + (width / 2);
		this.y2 = y + (height / 2);
		draw();
	}

	//Draws the Square, Original Algorithm from Part 1
	@Override
	protected void draw() {
		int tempx1 = x1;
		int tempx2 = x2;
		int tempy1 = y1;
		int tempy2 = y2;
		// Draws Top
		while (tempx1 != tempx2) {
			draw.showPoint(tempx1, y1);
			tempx1++;
		}
		// Draws Right
		while (tempy1 != tempy2) {
			draw.showPoint(x2, tempy1);
			tempy1++;
		}
		// Draws Bottom
		while (tempx2 != x1) {
			draw.showPoint(tempx2, y2);
			tempx2--;
		}
		// Draws Right
		while (tempy2 != y1) {
			draw.showPoint(x1, tempy2);
			tempy2--;
		}
	}

	// Erases the Square
	@Override
	protected void erase() {
		int tempx1 = x1;
		int tempx2 = x2;
		int tempy1 = y1;
		int tempy2 = y2;
		// Draws Top
		while (tempx1 != tempx2) {
			draw.hidePoint(tempx1, y1);
			tempx1++;
		}
		// Draws Right
		while (tempy1 != tempy2) {
			draw.hidePoint(x2, tempy1);
			tempy1++;
		}
		// Draws Bottom
		while (tempx2 != x1) {
			draw.hidePoint(tempx2, y2);
			tempx2--;
		}
		// Draws Right
		while (tempy2 != y1) {
			draw.hidePoint(x1, tempy2);
			tempy2--;
		}
	}
	
	//Checks the point in the Square
	@Override
	protected boolean checkPoint(int pX, int pY){
		if(((x1<pX && pX<x2)||pX==x1||pX==x2)&&((y1<pY && pY<y2)||pY==y1||pY==y2)){
			return true;
		}
		return false;
	}
}
