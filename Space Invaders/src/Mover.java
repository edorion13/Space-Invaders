import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
public abstract class Mover {

	double x, y, xVel, yVel;
	int width, height;
	Image image;

	public Mover (double x, double y, int width, int height, double xVel, double yVel, String fileName) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.xVel=xVel;
		this.yVel=yVel;
		try {image= ImageIO.read(new File(fileName));}
		catch (IOException e) {e.printStackTrace();};	

	}
		
	public void move() {
		x += xVel;
		y += yVel;   
	}
	public void paintSelf(Graphics g) {
		g.drawImage(image,(int)x,(int)y,width,height,null);
	}
	  public void setWidth(int w) {
		this.width = w;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	public int getHeight() {
		return height;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getY() {
		return y;
	}
	public void setXVel(double xVel) {
		this.xVel = xVel;
	}
	public double getXVel() {
		return xVel;
	}
	public void setYVel(double yVel) {
		this.yVel = yVel;
	}
	public double getYVel() {
		return yVel;
	}
}












