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
                //Load from Command Line
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                Date start = format.parse(args[2]+" "+args[3]);
                Date finish = format.parse(args[4]+" "+args[5]);
                List<Tweet> list=FileLines.fileInputLines(args[1],start,finish);
                //Load State
                IParser<List<State>> statesParser=new StateParser();
                java.util.List<String> listState= FileLines.fileInputLines("D:\\trends\\data\\states.json");
                java.util.List<State> allStates=statesParser.parse(listState.get(0));
                int[] arr=new int[allStates.size()];
                for (int i=0;i<list.size();i++){
                    try {
                        State state = list.get(i).getState(allStates);
                        arr[allStates.indexOf(state)]++;
                    }
                    catch (Throwable exc){}
                }
                int maxInd=0;
                for (int i=1;i<arr.length;i++)
                    if (arr[i]>arr[maxInd])
                        maxInd=i;
                System.out.println(allStates.get(maxInd).getName());
            }
        }
        catch (Throwable exc) {
            System.out.println(exc.getMessage());
        }
    }
}
