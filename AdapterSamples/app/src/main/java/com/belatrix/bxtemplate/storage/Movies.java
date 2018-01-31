package com.belatrix.bxtemplate.storage;




import com.belatrix.bxtemplate.model.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Profesor on 27/10/2016.
 */
public class Movies {

    //DATA SOURCE
    public static final String[] DATA = {"Batman", "Tiburón","Harry Potter",
            "DR. STRANGE","UNA PAREJA DISPAREJA","ROBERT EL MUNECO POSEIDO",
    "ENEMIGO EN LA RED","PRESENCIA DIABOLICA","Batman", "Tiburón","Harry Potter",
            "DR. STRANGE","UNA PAREJA DISPAREJA","ROBERT EL MUNECO POSEIDO",
            "MANOS DE PIEDRA","LA REINA DE KATWE"};

    public  List<MovieEntity> movieEntityList;

    public Movies() {
        movieEntityList= new ArrayList<>();
        movieEntityList.add(new MovieEntity("Batman","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));
        movieEntityList.add(new MovieEntity("Tiburón","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                true));
        movieEntityList.add(new MovieEntity("Harry Potter","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                true));
        movieEntityList.add(new MovieEntity("LA REINA DE KATWE","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));
        movieEntityList.add(new MovieEntity("ROBERT EL MUNECO POSEIDO","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                true));
        movieEntityList.add(new MovieEntity("UNA PAREJA DISPAREJA","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));;
        movieEntityList.add(new MovieEntity("ROBERT EL MUNECO POSEIDO","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));
        movieEntityList.add(new MovieEntity("ENEMIGO EN LA RED","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));
        movieEntityList.add(new MovieEntity("ROBERT EL MUNECO POSEIDO","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                true));;
        movieEntityList.add(new MovieEntity("LA REINA DE KATWE","Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\".",
                false));
    }

    public List<MovieEntity> getMovieEntityList() {
        return movieEntityList;
    }
}
