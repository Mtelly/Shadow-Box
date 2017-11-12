package com.example.extropy.shadowbox;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dennis on 9/3/17.
 */

public class Preference implements Parcelable {
    private boolean southpaw = false;
    private int difficulty = 0;

     Preference(boolean southpaw, int difficulty) {
        this.southpaw = southpaw;
        this.difficulty = difficulty;
    }

    public boolean getSouthpaw() {
        return southpaw;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setSouthpaw(boolean southpaw) {
        this.southpaw = southpaw;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    protected Preference(Parcel in) {
        southpaw = in.readByte() != 0x00;
        difficulty = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (southpaw ? 0x01 : 0x00));
        dest.writeInt(difficulty);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Preference> CREATOR = new Parcelable.Creator<Preference>() {

        @Override
        public Preference createFromParcel(Parcel in) {
            return new Preference(in);
        }

        @Override
        public Preference[] newArray(int size) {
            return new Preference[size];
        }

    };
}