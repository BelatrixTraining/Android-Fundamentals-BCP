package com.belatrix.bxtemplate.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 27/01/17.
 */

public class Receta implements Serializable{

    private int id;
    private String title;
    private String desc;
    private boolean favorite;

    public Receta() {
    }


    public Receta(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Receta(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public Receta(int id, String title, String desc, boolean favorite) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}
