package com.fuck.viewtest.seria;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable {
    private String name;
    public static final Creator<Dog> CREATOR = new DogCreator();

    Dog(Parcel in) {
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
