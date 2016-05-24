package files.tweet;

import files.tweet.Tweet;
import files.tweet.TweetParser;

import java.util.*;

public class FindByHashTag {
    public static List<Tweet> output(List<Tweet> list, String hashtag){
        List<Tweet> result=new ArrayList<>();
        if (hashtag.charAt(0)!='#')
            hashtag="#"+hashtag;
        for(Tweet line:list)
        {
            String mes=line.getMessage();
            if(mes.contains(hashtag))
                result.add(line);
        }
        return result;
    }
}
