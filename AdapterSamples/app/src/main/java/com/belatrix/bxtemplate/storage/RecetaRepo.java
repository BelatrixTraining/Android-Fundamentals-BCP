package com.belatrix.bxtemplate.storage;


import com.belatrix.bxtemplate.model.Receta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class RecetaRepo {

    private List<Receta> recetas;

    public RecetaRepo() {
        recetas= new ArrayList<>();
        recetas.add(new Receta(100,"Adobo de chancho",
                "El adobo es un estilo de preparación proveniente de Europa; pero en Perú..",
                true));

        recetas.add(new Receta(101,"Aguadito",
                "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..",
                false));

        recetas.add(new Receta(102,"Ajiaco de papas",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                true));

        recetas.add(new Receta(103,"Ají de gallina",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                true));

        recetas.add(new Receta(104,"Ajiaco de papas",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                false));

        recetas.add(new Receta(105,"Aguadito",
                "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre,"));

        recetas.add(new Receta(106,"Adobo de chancho",
                "El adobo es un estilo de preparación proveniente de Europa; pero en Perú",
                true));
    }

    public List<Receta> getRecetas() {
        return recetas;
    }
}
