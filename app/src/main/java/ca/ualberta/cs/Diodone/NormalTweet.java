/*
 * CMPUT 301
 *
 * Version 1.3
 *
 * 1/22/19 6:33 PM
 *
 * Copyright (c) 2019. All rights reserved.
 */

package ca.ualberta.cs.Diodone;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

/**
 * A class which represents a single message and associated data
 * @author Ryan Jensen
 * @version 1.3
 */
public class NormalTweet extends Tweet implements Parcelable {

    public UUID getUnique() {
        return Unique;
    }

    public void setUnique(UUID unique) {
        Unique = unique;
    }

    /**
     * Creates a NormalTweet object with the provided message
     * @param message a String
     */
    public NormalTweet(String message){
        this.message = message;
        this.Unique = UUID.randomUUID();
    }
    public NormalTweet(){
        this.message = "";
    }
    /**
     * Changes the message stored to a new message, overwriting the previous message
     * @param message a new String
     */
    @Override
    public void setTweetBody(String message){
        this.message = message;
    }

    /**
     * Obtains the message stored.
     * @return the current message
     */
    public String getMessage(){
        return message;
    }

    /**
     * Converts the NormalTweet object into a String object
     * @return Returns a string representing the message
     */
    @Override
    public String toString() {
        return message;
    }

    protected NormalTweet(Parcel in) {
        message = in.readString();
        long tmpDate = in.readLong();
        date = tmpDate != -1 ? new Date(tmpDate) : null;
        Unique = (UUID) in.readValue(UUID.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeLong(date != null ? date.getTime() : -1L);
        dest.writeValue(Unique);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<NormalTweet> CREATOR = new Parcelable.Creator<NormalTweet>() {
        @Override
        public NormalTweet createFromParcel(Parcel in) {
            return new NormalTweet(in);
        }

        @Override
        public NormalTweet[] newArray(int size) {
            return new NormalTweet[size];
        }
    };
}