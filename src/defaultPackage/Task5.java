package defaultPackage;

import defaultPackage.ConsoleOutput;
import defaultPackage.ITask;
import files.FileLines;
import files.IListParser;
import files.IParser;
import files.sentiment.EmotionalWeight;
import files.tweet.FindByHashTag;
import files.tweet.Tweet;
import files.tweet.TweetParser;
import files.sentiment.Sentiment;
import files.sentiment.SentimentParser;
import files.state.State;
import files.state.StateParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by korol on 24.05.16.
 */
public class Task5 implements ITask {
    public void task(String[] args){
        try {
            IListParser<Tweet> tweetParser=new TweetParser();
            if (args[0].equals("0")) {
                List<String> list = FileLines.fileInputLines(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                ConsoleOutput.ListTweets(FindByHashTag.output(tweetParser.parse(list), args[4]));
            }
            else if (args[0].equals("1")){
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                Date start = format.parse(args[2]+" "+args[3]);
                Date finish = format.parse(args[4]+" "+args[5]);
                List<Tweet> list=FileLines.fileInputLines(args[1],start,finish);
                IListParser<Sentiment> sent=new SentimentParser();
                EmotionalWeight weight=new EmotionalWeight(sent.parse(FileLines.fileInputLines("D:\\trends\\data\\sentiments.csv")));
                System.out.println(weight.Find(list));
            }
            else if (args[0].equals("2")){
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                Date start = format.parse(args[2]+" "+args[3]);
                Date finish = format.parse(args[4]+" "+args[5]);
                List<Tweet> list=FileLines.fileInputLines(args[1],start,finish);
                IParser<List<State>> statesParser=new StateParser();
                List<String> listy=FileLines.fileInputLines("D:\\trends\\data\\states.json");
                List<State> allStates=statesParser.parse(listy.get(0));
                while (true);
            }
        }
        catch (Throwable exc) {
            System.out.println(exc.getMessage());
        }
    }
}
