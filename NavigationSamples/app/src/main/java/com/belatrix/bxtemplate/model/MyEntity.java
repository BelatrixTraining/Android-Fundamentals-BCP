package com.belatrix.bxtemplate.model;

import java.io.Serializable;

/**
 * Created by emedinaa on 30/01/18.
 */

public class MyEntity implements Serializable {

    private int id;
    private int desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
