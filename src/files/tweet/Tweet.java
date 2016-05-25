package files.tweet;

import defaultPackage.Coordinate;
import files.FileLines;
import files.IParser;
import files.state.State;
import files.state.StateParser;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Date;
import java.util.List;
import java.awt.geom.Point2D.Double;

public class Tweet{
	private Coordinate coordinate;
	public Coordinate getCoordinate(){
		return coordinate;
	}

	
	private Date date;
	public Date getDate(){
		return date;
	}
	
	private String message;
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	
	public Tweet(double latitude, double longitude, Date date, String message){
		this.coordinate=new Coordinate(latitude,longitude);
		this.date=date;
		this.message=message;
	}

	public Tweet(Coordinate coordinate, Date date, String message){
		this.coordinate=coordinate;
		this.date=date;
		this.message=message;
	}

	public State getState(){
		IParser<List<State>> statesParser=new StateParser();
		java.util.List<String> list= FileLines.fileInputLines("D:\\trends\\data\\states.json");
		java.util.List<State> allStates=statesParser.parse(list.get(0));
		return getState(allStates);
	}
	public State getState(List<State> list){
		Point point=new Point((int)(coordinate.getLongitude()*10),(int)(coordinate.getLatitude()*10));
		State state =null;
		for (int i=0;i<list.size();i++)
			if (list.get(i).constains(point)) {
				state = list.get(i);
				break;
			}
		return state;
	}
}
