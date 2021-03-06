package ca.ualberta.cs.lonelytwitter;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LonelyTwitterActivityTest {
    @Test
    public void addTest(){
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp1 = new Tweet("HI");
        Tweet temp2 = new Tweet("HI");
        try{
            holder.addTweet(temp1);
        } catch(IllegalArgumentException e){
            assertEquals(1,-1);
        }
        try{
            holder.addTweet(temp1);
            assertEquals(1,-1);
        } catch(IllegalArgumentException e){
        }
        try {
            holder.addTweet(temp2);
        } catch (IllegalArgumentException e){
            assertEquals(1,-1);
        }
    }

    @Test
    public void getTweetsTest(){
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp1 = new Tweet("ZI");
        Tweet temp2 = new Tweet("HI");
        Tweet temp3 = new Tweet("AI");
        Tweet temp4 = new Tweet("AI");
        ArrayList<Tweet> expected = new ArrayList<Tweet>();
        ArrayList<Tweet> obtained = holder.getTweets();
        assertEquals(expected.toArray(), obtained.toArray());
        holder.addTweet(temp3);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp3);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp1);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp1);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp4);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp4);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
        holder.addTweet(temp2);
        assertNotEquals(expected.toArray(), holder.getTweets().toArray());
        expected.add(temp2);
        assertEquals(expected.toArray(), holder.getTweets().toArray());
    }

    @Test
    public void hasTest(){
        // violates some encapsulation principles in order to put 2 of the same object into tweetlist
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp3 = new Tweet("AI");
        Tweet temp4 = new Tweet("AI");
        // assumes we can directly modify the stored tweetlist for the test
        holder.addTweet(temp3);
        holder.addTweet(temp4);
        assertEquals(false, holder.hasTweet());
        ArrayList<Tweet> obtained = holder.getTweets();
        obtained.add(temp3);
        assertEquals(true, holder.hasTweet());
        obtained.remove(obtained.get(obtained.size()-1));
        assertEquals(false, holder.hasTweet());

    }

    @Test
    public void getCountTest(){
        LonelyTwitterActivity holder = new LonelyTwitterActivity();
        Tweet temp1 = new Tweet("ZI");
        Tweet temp2 = new Tweet("HI");
        Tweet temp3 = new Tweet("AI");
        Tweet temp4 = new Tweet("AI");
        assertEquals(0,holder.getCount());
        holder.addTweet(temp1);
        assertEquals(1,holder.getCount());
        holder.addTweet(temp2);
        assertEquals(2,holder.getCount());
        holder.addTweet(temp3);
        assertEquals(3,holder.getCount());
        holder.addTweet(temp4);
        assertEquals(4,holder.getCount());
    }
}
