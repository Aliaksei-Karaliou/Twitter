package files.sentiment;

import files.FileLines;
import files.IListParser;
import files.sentiment.Sentiment;
import files.sentiment.SentimentParser;
import files.tweet.Tweet;

import java.util.*;

public class EmotionalWeight {
    private Hashtable<String, Double> dict;

    public  EmotionalWeight(List<Sentiment> sentiments){
        dict=new Hashtable();
        for (Sentiment t:sentiments)
            dict.put(t.getMessage(),t.getEmotion());
    }

    private static String deletePunctation(String word, String[] punc){
        String result=word;
        for (int i=0;i<punc.length;i++)
            if (result.contains(punc[i]))
                result = result.replace(punc[i],"");
        return result;
    }

    public double Find(List<Tweet> tweets){
        double result=0;
        for (Tweet t:tweets){
            String[] words=t.getMessage().split(" ");
            for (int i=0;i<words.length;i++)
            {
                words[i]=deletePunctation(words[i].toLowerCase(),new String[]{".",",","?",":","!"});
                if (dict.containsKey(words[i]))
                    result+=dict.get(words[i]);
            }
        }
        return result;
    }
}
