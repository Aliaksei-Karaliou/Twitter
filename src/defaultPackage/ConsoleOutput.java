package defaultPackage;

import files.tweet.Tweet;

import java.util.*;

public class ConsoleOutput{
	public static void ListString(List<String> list){
		for (int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}
	public static void ListTweets(List<Tweet> list){
		for (int i=0;i<list.size();i++)
			System.out.println(list.get(i).getMessage());
	}
}
