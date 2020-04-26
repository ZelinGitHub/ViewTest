package com.fuck.viewtest.Bean;


import android.os.Parcel;
import android.os.Parcelable;

public class DogCreator implements Parcelable.Creator<Dog> {

    @Override
    public Dog createFromParcel(Parcel source) {
        return new Dog(source);
    }

    @Override
    public Dog[] newArray(int size) {
        return new Dog[size];
    }
}
