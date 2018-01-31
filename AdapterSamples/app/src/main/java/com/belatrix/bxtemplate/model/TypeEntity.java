package com.belatrix.bxtemplate.model;

/**
 * Created by emedinaa on 27/01/17.
 */

public class TypeEntity {

    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public  boolean isMovie(){
        return false;
    }
    public boolean isPlace(){
        return false;
    }

}
