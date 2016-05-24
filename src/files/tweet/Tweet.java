package files.tweet;

import defaultPackage.Coordinate;

import java.util.Date;

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
}
