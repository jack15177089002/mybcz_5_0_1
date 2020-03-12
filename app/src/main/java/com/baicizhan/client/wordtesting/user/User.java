package com.baicizhan.client.wordtesting.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        public final User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        public final User[] newArray(int i) {
            return new User[i];
        }
    };
    private String name;
    private String token;

    public String toString() {
        return "<name:" + this.name + " token:" + this.token + ">";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public User() {
    }

    public User(Parcel parcel) {
        this.name = parcel.readString();
        this.token = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.token);
    }
}
