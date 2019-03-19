package ca.ualberta.cs.Diodone;

public class ImportantTweet extends Tweet {
    public void setTweetBody(String message){
        if(message.length() <40) {
            this.message = message;
        }
    }
}
