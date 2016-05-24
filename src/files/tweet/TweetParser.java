package files.tweet;

import defaultPackage.Coordinate;
import files.IListParser;
import files.IParser;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TweetParser implements IParser<Tweet>, IListParser<Tweet> {

	@Override
	public Tweet parse(String line) {
		String[] parsing=line.split("\t");
		Coordinate coor=new Coordinate(parsing[0]);
		Date date=new Date();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			date= format.parse(parsing[2]);
		} 
		catch (ParseException e) {
			e.printStackTrace();
			date=null;
		}
		return new Tweet(coor, date, parsing[3]);
	}

	@Override
	public List<Tweet> parse(List<String> list){
		List<Tweet> result=new ArrayList();
		for (String s:list)
			result.add(parse(s));
		return result;
	}
}