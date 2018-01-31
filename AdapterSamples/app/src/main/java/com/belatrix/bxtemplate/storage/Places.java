package com.belatrix.bxtemplate.storage;


import com.belatrix.bxtemplate.model.PlaceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class Places {

    private List<PlaceEntity> places;

    public Places() {
        this.places= new ArrayList<>();
        places.add(new PlaceEntity(0,"Alcazar"));
        places.add(new PlaceEntity(1,"Brasil"));
        places.add(new PlaceEntity(2,"Centro"));
        places.add(new PlaceEntity(2,"Centro Cívico"));
        places.add(new PlaceEntity(2,"Guardia Cívil"));
        places.add(new PlaceEntity(2,"Comas"));
    }

    public List<PlaceEntity> getPlaces() {
        return places;
    }

}
