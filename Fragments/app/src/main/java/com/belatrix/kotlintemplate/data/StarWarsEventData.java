package com.belatrix.kotlintemplate.data;


import com.belatrix.kotlintemplate.model.StarWarsEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 15/08/17.
 * http://www.starwars.com/events
 */

public class StarWarsEventData {


    private final String DOMAIN="http://starwarsblog.starwars.com/wp-content/uploads";
    private List<StarWarsEvent> eventList;

    public List<StarWarsEvent> getEventList() {
        return eventList;
    }


    public List<StarWarsEvent> generate() {
        StarWarsEvent event1 = new StarWarsEvent();
        event1.setTitle("Star Wars Identities");
        //event1.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2015/09/starwars_identities-1440x480-961496775178.jpg");
        event1.setPhoto(DOMAIN+"/2015/09/starwars_identities-1440x480-961496775178.jpg");
        //http://starwarsblog.starwars.com/wp-content/uploads/2015/09/starwars_identities-1440x480-961496775178.jpg

        StarWarsEvent event2 = new StarWarsEvent();
        event2.setTitle("Star Wars Night with the NY Yankees");
        //event2.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2017/05/events-starwarsday-mlb-banner-900x300-3.jpg");
        event2.setPhoto(DOMAIN+"/2017/05/events-starwarsday-mlb-banner-900x300-3.jpg");

        StarWarsEvent event3 = new StarWarsEvent();
        event3.setTitle("Star Wars Night with the Chicago White Sox");
        //event3.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2016/06/events-starwarsday-mlb-banner-900x300-1.jpg");
        event3.setPhoto(DOMAIN+"/2016/06/events-starwarsday-mlb-banner-900x300-1.jpg");

        StarWarsEvent event4 = new StarWarsEvent();
        event4.setTitle("Star Wars Night with the SF Giants");
        //event4.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2017/05/events-starwarsday-mlb-banner-900x300-2.jpg");
        event4.setPhoto(DOMAIN+"/2017/05/events-starwarsday-mlb-banner-900x300-2.jpg");

        StarWarsEvent event5 = new StarWarsEvent();
        event5.setTitle("Star Wars Night with the Texas Rangers");
        //event5.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2017/05/events-starwarsday-mlb-banner-900x300-3.jpg");
        event5.setPhoto(DOMAIN+"/2017/05/events-starwarsday-mlb-banner-900x300-3.jpg");

        StarWarsEvent event6 = new StarWarsEvent();
        event6.setTitle("Star Wars Night with the Kansas City Royals");
        //event6.setPhoto("http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2016/06/events-starwarsday-mlb-banner-900x300-1.jpg");
        event6.setPhoto(DOMAIN+"/2016/06/events-starwarsday-mlb-banner-900x300-1.jpg");

        eventList= new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);
        eventList.add(event5);
        eventList.add(event6);

        return eventList;
    }

}
