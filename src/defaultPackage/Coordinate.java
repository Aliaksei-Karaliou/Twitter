package defaultPackage;

public class Coordinate {
	private double latitude;
	public double getLatitude(){
		return latitude;
	}
	public void setLatitude(double latitude){
		this.latitude=latitude;
	}
	
	private double longitude;
	public double getLongitude(){
		return longitude;
	}
	public void setLongitude(double longitude){
		this.longitude=longitude;
	}
	
	public Coordinate(double latitude, double longitude){
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public Coordinate (String coor)	{
		coor=coor.substring(1,coor.indexOf(']'));
		String[] res=coor.split(", ");
		latitude=Double.parseDouble(res[0]);
		longitude=Double.parseDouble(res[1]);
	}
	
	@Override
	public String toString(){
		return "("+latitude+", "+longitude+")";
	}
}
