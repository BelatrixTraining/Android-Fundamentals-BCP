package com.belatrix.bxtemplate.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emedinaa on 30/01/18.
 */

public class MyPEntity implements Parcelable {

    protected MyPEntity(Parcel in) {
    }

    public static final Creator<MyPEntity> CREATOR = new Creator<MyPEntity>() {
        @Override
        public MyPEntity createFromParcel(Parcel in) {
            return new MyPEntity(in);
        }

        @Override
        public MyPEntity[] newArray(int size) {
            return new MyPEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
