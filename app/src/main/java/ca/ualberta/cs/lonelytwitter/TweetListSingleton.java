package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListSingleton {
    private static TweetListSingleton instance = null;
    private ArrayList<Tweet> tweetList;
    private TweetListSingleton(){
        tweetList = new ArrayList<>();
    }

    public void setTweetList(ArrayList<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public ArrayList<Tweet> getTweetList(){
        return this.tweetList;
    }
    public static TweetListSingleton getInstance(){
        if(instance == null){
            instance = new TweetListSingleton();
        }
        return instance;
    }
}
