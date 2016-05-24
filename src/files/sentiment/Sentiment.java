package files.sentiment;

public class Sentiment{

	private double emotion;
	public double getEmotion(){
		return emotion;
	}
	public void setEmotion(double emotion){
		this.emotion=emotion;
	}
	
	private String message;
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	
	public Sentiment(double emotion, String message){
		this.emotion=emotion;
		this.message=message;
	}

}
