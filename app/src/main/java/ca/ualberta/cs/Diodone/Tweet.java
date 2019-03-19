package ca.ualberta.cs.Diodone;

import java.util.Date;
import java.util.UUID;

public abstract class Tweet {
    protected String message;
    protected Date date;
    protected UUID Unique;

    public abstract void setTweetBody(String message);
}
