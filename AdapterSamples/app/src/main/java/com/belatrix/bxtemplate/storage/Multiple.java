package com.belatrix.bxtemplate.storage;


import com.belatrix.bxtemplate.model.MovieEntity;
import com.belatrix.bxtemplate.model.PlaceEntity;
import com.belatrix.bxtemplate.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class Multiple {

    private List<TypeEntity>  objects;

    public Multiple() {
        objects= new ArrayList<>();
        objects.add(new PlaceEntity(0,"Alcazar"));
        objects.add(new MovieEntity("Batman",true));
        objects.add(new PlaceEntity(1,"Brasil"));
        objects.add(new MovieEntity("LA REINA DE KATWE",false));
        objects.add(new PlaceEntity(2,"Centro"));
        objects.add(new PlaceEntity(2,"Centro Cívico"));
        objects.add(new MovieEntity("Tiburón",false));
        objects.add(new PlaceEntity(2,"Guardia Cívil"));
        objects.add(new PlaceEntity(2,"Comas"));
        objects.add(new MovieEntity("Harry Potter",true));
        objects.add(new MovieEntity("UNA PAREJA DISPAREJA",true));
    }

    public List<TypeEntity> getObjects() {
        return objects;
    }


}
