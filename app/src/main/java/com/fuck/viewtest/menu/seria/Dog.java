package com.fuck.viewtest.menu.seria;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

public class Dog implements Parcelable {
    public int age;
    public String name;
    public static final Creator<Dog> CREATOR = new DogCreator();

    Dog() {

    }

    Dog(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @NotNull
    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hashCode='" + hashCode() + '\'' +
                '}';
    }
}
