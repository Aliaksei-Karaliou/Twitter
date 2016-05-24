package files.sentiment;

import files.IListParser;
import files.IParser;
import java.util.List;
import java.util.ArrayList;

public class SentimentParser implements IParser<Sentiment>, IListParser<Sentiment> {

	@Override
	public Sentiment parse(String line) {
		String[] parsing=line.split(",");
		return new Sentiment(Double.parseDouble(parsing[1]),parsing[0]);
	}
	@Override
	public  List<Sentiment> parse (List<String> list){
		List<Sentiment> result=new ArrayList();
		for (String s:list)
			result.add(parse(s));
		return  result;
	}
}
