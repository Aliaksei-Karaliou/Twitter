package files.state;

import defaultPackage.Coordinate;
import files.IParser;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class State{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}

	private Coordinate[] points;
	public Coordinate[] getCoordinates(){
		return points;
	}
	public State(String name){
		this.name=name;
		points=new Coordinate[0];
	}

	public void AddCoordinate(Coordinate newCoordinate) {
		ArrayList<Coordinate> buf = new ArrayList<Coordinate>(Arrays.asList(points));
		buf.add(newCoordinate);
		points = buf.toArray(points);
	}

	private Polygon getPolygon(){
		Polygon result=new Polygon();
		for (int i=0;i<points.length;i++)
			result.addPoint((int)(points[i].getLatitude()*10),(int)(points[i].getLongitude()*10));
		return result;
	}
	public boolean constains(Point point){
		Polygon polygon=getPolygon();
		return polygon.contains(point);
	}

	@Override
	public boolean equals(Object obj) {
		return ((State)obj).getName()==name;
	}
}
