package files;

import files.tweet.Tweet;
import files.tweet.TweetParser;

import java.io.*;
import java.util.*;

public class FileLines
{
	public static List<String> fileInputLines (String filename, int firstLine, int number){
		int line=1;	
		int finishLine=firstLine+number-1;
		List<String> result=new Vector();
		try (FileReader reader=new FileReader(filename)){
			StringBuilder thisLine = new StringBuilder();
			int c;
			while((c=reader.read())!=-1){
				char symbol=(char)c;
				
				if (symbol=='\n'){					
				if (line>=firstLine && line<=finishLine){
                        result.add(thisLine.toString());
                    }
				line++;
				thisLine.delete(0, thisLine.length());
				}
				else thisLine.append(symbol);
				if (line>finishLine)
					break;
			}
			if (thisLine.length()>0)
				result.add(thisLine.toString());
		}
		catch(IOException ex){            
		    System.out.println(ex.getMessage());
		}
		return result;
	}
	public static List<String> fileInputLines (String filename){
		return fileInputLines(filename,1,Integer.MAX_VALUE);
	}
	public static List<Tweet> fileInputLines(String filename, Date start, Date finish)
	{
		List<Tweet> result=new Vector();
        IParser<Tweet> parser=new TweetParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line=br.readLine())!=null){
				Tweet tweet=parser.parse(line);
				Date date=tweet.getDate();
				if (!date.before(start) && !date.after(finish))
					result.add(tweet);
				else if (date.after(finish))
					break;
			}
		}
		catch (IOException ex) {}

		return  result;
	}
}