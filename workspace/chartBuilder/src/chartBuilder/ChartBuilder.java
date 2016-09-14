package chartBuilder;

import csci348.drawings.Drawing;
import java.util.ArrayList;
import java.util.Scanner;

//Class that Builds Charts using Squares and Lines
public class ChartBuilder {
	//The Private Variables
	private Drawing draw=new Drawing();
	private ArrayList<Square> squareList=new ArrayList<Square>();
	private ArrayList<Line> lineList=new ArrayList<Line>();
	
	//Square Sub-Class that makes the Squares for the Charts
	private class Square {
		//Private Location Varables
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		
		//Constructor that takes the Command of the Mid-Point and, Width and Height
		private Square(int x, int y, int width, int height){
			this.x1=x-(width/2);
			this.y1=y-(height/2);
			this.x2=x+(width/2);
			this.y2=y+(height/2);
			drawSquare();
		}
		//The Draw Method
		private void drawSquare(){
			int tempx1=x1;
			int tempx2=x2;
			int tempy1=y1;
			int tempy2=y2;
			//Draws Top
			while(tempx1!=tempx2){
				draw.showPoint(tempx1, y1);
				tempx1++;
			}
			//Draws Right
			while(tempy1!=tempy2){
				draw.showPoint(x2, tempy1);
				tempy1++;
			}
			//Draws Bottom
			while(tempx2!=x1){
				draw.showPoint(tempx2, y2);
				tempx2--;
			}
			//Draws Right
			while(tempy2!=y1){
				draw.showPoint(x1, tempy2);
				tempy2--;
			}
		}
		//Erase Method
		private void eraseSquare(){
			int tempx1=x1;
			int tempx2=x2;
			int tempy1=y1;
			int tempy2=y2;
			//Draws Top
			while(tempx1!=tempx2){
				draw.hidePoint(tempx1, y1);
				tempx1++;
			}
			//Draws Right
			while(tempy1!=tempy2){
				draw.hidePoint(x2, tempy1);
				tempy1++;
			}
			//Draws Bottom
			while(tempx2!=x1){
				draw.hidePoint(tempx2, y2);
				tempx2--;
			}
			//Draws Right
			while(tempy2!=y1){
				draw.hidePoint(x1, tempy2);
				tempy2--;
			}
		}
	}
	
	//Line Subclass that makes lines for the chart
	private class Line {
		//Private Location Variables
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		//Constructor that takes the two points
		private Line(int x1, int y1, int x2, int y2){
			this.x1=x1;
			this.y1=y1;
			this.x2=x2;
			this.y2=y2;
			drawLine();	
			
		}
		//Draws the Line by first doing half the Y line, then the full X line,
		//and finally the rest of the Y line
		private void drawLine(){
			//Temp Variables for the points
			int tempy2=(y1+y2)/2;//midpoint
			int tempy1=tempy2;//smaller y
			int tempy3=tempy2;//larger y
			int tempx1=0;//smaller x
			int tempx2=0;//larger x
			
			//Checks to find the larger of the variables
			if(y2>y1){
				tempy1=y1;
				tempy3=y2;
			}
			else if(y2<y1){
				tempy1=y2;
				tempy3=y1;
			}
			if(x2>x1){
				tempx1=x1;
				tempx2=x2;
			}
			else if(x2<x1){
				tempx1=x2;
				tempx2=x1;
			}
			//Draws the first half of the Y line
			while(tempy1!=tempy2){
				draw.showPoint(x1, tempy1);
				tempy1++;
			}
			//Draws the X Line
			while(tempx1!=tempx2){
				draw.showPoint(tempx1, tempy2);
				tempx1++;
			}
			//Draws the Second half of the Y line
			while(tempy2!=tempy3){
				draw.showPoint(x2, tempy2);
				tempy2++;
			}
		}
		//Erase Function(Same as Draw but has hidepoints instead of showpoints)
		private void eraseLine(){
			int tempy2=(y1+y2)/2;//midpoint
			int tempy1=tempy2;//smaller y
			int tempy3=tempy2;//larger y
			int tempx1=0;//smaller x
			int tempx2=0;//larger x
			
			if(y2>y1){
				tempy1=y1;
				tempy3=y2;
			}
			else if(y2<y1){
				tempy1=y2;
				tempy3=y1;
			}
			if(x2>x1){
				tempx1=x1;
				tempx2=x2;
			}
			else if(x2<x1){
				tempx1=x2;
				tempx2=x1;
			}
			while(tempy1!=tempy2){
				draw.hidePoint(x1, tempy1);
				tempy1++;
			}
			while(tempx1!=tempx2){
				draw.hidePoint(tempx1, tempy2);
				tempx1++;
			}
			while(tempy2!=tempy3){
				draw.hidePoint(x2, tempy2);
				tempy2++;
			}
		}
	}
	
	//The charts drawLine function that creates a sub-classed Line and stores that line
	//in the line list(An ArrayList of Type Line)
	public void drawLine(int x1, int y1, int x2, int y2){
		Line l=new Line(x1,y1,x2,y2);
		lineList.add(l);
	}
	
	//The chart drawSquare function that creates a sub-classed Square and stores that
	//in to the square list(An ArrayList of Type Square)
	public void drawSquare(int x, int y, int width, int height){
		Square s=new Square(x,y, width, height);
		squareList.add(s);
	}
	
	//Reset method that Resets the Drawing and lists
	public void reset(){
		draw.hideAllPoints();
		squareList=new ArrayList<Square>();
		lineList=new ArrayList<Line>();
	}
	
	//Erases a Square at the given index using the Squares Erase Method, 
	//and removes it from the list
	public void eraseSquare(int ind){
		squareList.get(ind).eraseSquare();
		squareList.remove(ind);
	}
	
	//Erases a Line at the given index, using the Lines Erase Method, 
	//and removes it from the list
	public void eraseLine(int ind){
			lineList.get(ind).eraseLine();
			lineList.remove(ind);
	}
	
	//Erases the last drawn Line
	public void eraseLastLine(){
			lineList.get(lineList.size()-1).eraseLine();
			lineList.remove(lineList.size()-1);
		
	}
	
	//Erases the last draw Square
	public void eraseLastSquare(){
		if(!lineList.isEmpty()){
			squareList.get(squareList.size()-1).eraseSquare();
			squareList.remove(squareList.size()-1);
		}
	}
	
	//Testing
	public static void main(String[] args) {
		ChartBuilder cb=new ChartBuilder();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Testing the Drawing of Lines and Squares, Hit Enter");
		sc.nextLine();
		cb.drawSquare(300, 230, 100, 50);
		cb.drawSquare(500, 400, 100, 50);
		cb.drawLine(301, 255, 500, 375);
		cb.drawSquare(300,400,100,50);
		cb.drawLine(300,255,300,375);
		cb.drawSquare(100,400,100,50);
		cb.drawLine(299, 255, 100, 375);
		cb.drawSquare(500, 100, 100, 50);
		cb.drawLine(500, 125, 301, 205);
		cb.drawSquare(100, 100, 100, 50);
		cb.drawLine(100,125,299,205);
		cb.drawSquare(500, 230, 100, 100);
		cb.drawLine(350, 230, 450, 230);
		
		System.out.println("Testing of Erase Last Square and Line, Hit Enter");
		sc.nextLine();
		cb.eraseLastLine();
		cb.eraseLastSquare();
		
		System.out.println("Testing Erase of an Index of Square and Line, Hit Enter");
		sc.nextLine();
		cb.eraseLine(3);
		cb.eraseSquare(4);
		
		System.out.println("Testing Reset, Hit Enter");
		sc.hasNextLine();
		cb.reset();
	}

}
