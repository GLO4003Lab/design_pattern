package ca.ulaval.glo4003.labodesignpatterns1.prototype;

import java.awt.Point;
import java.util.Arrays;

public class Polygon2D{

	Point[] points = new Point[12];
	private int x = 0;
	private int y = 0;

	public Polygon2D(int x, int y) {
		this.x = x;
		this.y = y;
		evaluateCoordinatesOfPoints();
	}
	
	private Polygon2D(int x, int y,Point[] points){
		this.x = x;
		this.y = y;
		this.points = points;
	}

	private void evaluateCoordinatesOfPoints() {
		// Ne prennez pas en compte cet algorithme. Il s'agit d'un algorithme au
		// hasard pour créer une suite de points servant de sommets pour le
		// Polygone. Ne changez pas ce code.
		for (int i = 0; i < points.length; i++) {
			Point point = new Point(x + i * 2 + 1, y + i * i - 4);
			points[i] = point;
			try {
				Thread.sleep(50l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "Polygon2D:" + " Center:[x=" + x + ", y=" + y + "], Points="
				+ Arrays.toString(points);
	}

	private void translate(int newX, int newY) {
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(points[i].x - x + newX, points[i].y - y
					+ newY);
		}
		x = newX;
		y = newY;
	}

	protected Polygon2D clone(int x, int y){
		
		Polygon2D polygon2d = new Polygon2D(this.x, this.y,this.points);
		polygon2d.translate(x, y);
		return polygon2d;
	}
	
	
}
