package com.cowman.turlough.spinnertest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turlough on 14/11/15.
 */
public class StopList  {

    List<Stop> stops = new ArrayList<Stop>();


    public StopList() {
        stops.add(new Stop(23, 1, "Douglas"));
        stops.add(new Stop(57, 2, "Mahon"));
        stops.add(new Stop(99, 3, "Blackrock"));
        stops.add(new Stop(65, 4, "Victoria Road"));
        stops.add(new Stop(88, 5, "Town Centre"));
    }

    public List<Stop> getStops() {
        return stops;
    }

    public int size(){
        return stops.size();
    }
}
