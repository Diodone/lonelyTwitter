package ca.ualberta.cs.Diodone;

import java.util.ArrayList;

public class TweetListSingleton {
    private static TweetListSingleton instance = null;
    private ArrayList<NormalTweet> tweetList;
    private TweetListSingleton(){
        tweetList = new ArrayList<>();
    }

    public void setTweetList(ArrayList<NormalTweet> tweetList) {
        this.tweetList = tweetList;
    }

    public ArrayList<NormalTweet> getTweetList(){
        return this.tweetList;
    }
    public static TweetListSingleton getInstance(){
        if(instance == null){
            instance = new TweetListSingleton();
        }
        return instance;
    }
}
