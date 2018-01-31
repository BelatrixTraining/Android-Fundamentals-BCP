package com.belatrix.kotlintemplate.model;

import android.os.Parcel;

/**
 * Created by emedinaa on 15/08/17.
 */

public class StarWarsEvent extends BaseModel  {
    private String title;
    private String description;
    private String photo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public StarWarsEvent() {
    }

    private StarWarsEvent(Parcel in) {
        title = in.readString();
        description = in.readString();
        photo = in.readString();
    }

    public static final Creator<StarWarsEvent> CREATOR = new Creator<StarWarsEvent>() {
        @Override
        public StarWarsEvent createFromParcel(Parcel in) {
            return new StarWarsEvent(in);
        }

        @Override
        public StarWarsEvent[] newArray(int size) {
            return new StarWarsEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(photo);
    }

    @Override
    public String toString() {
        return "StarWarsEvent{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
