package com.cowman.turlough.spinnertest;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by turlough on 14/11/15.
 */

public class StopAdapter extends ArrayAdapter {

    SparseArray<Stop> stopMap = new SparseArray<>();
    int numStops;
//    int disabledTo;
//    int disabledFrom;


    public StopAdapter(Context context, int resource, List<Stop> objects) {

        super(context, resource, objects);

        numStops = objects.size();
//        disabledTo = 0;
//        disabledFrom = numStops;

        for (int i = 0; i < numStops; i++) {
            stopMap.put(i, objects.get(i));
        }
    }

    public Stop getStop(int position) {
        return stopMap.get(position);
    }

    public void disableTop(int position) {
        for (int i = 0; i < numStops; i++) {
            Stop.State state = i < position ? Stop.State.DISABLED : Stop.State.ENABLED;
            getStop(i).setState(state);
        }
    }

    public void disableBottom(int position) {
        for (int i = 0; i < numStops; i++) {
            Stop.State state = i > position ? Stop.State.DISABLED : Stop.State.ENABLED;
            getStop(i).setState(state);
        }
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);

        Stop.State state = getStop(position).getState();
        switch (state) {
            case DISABLED:
                view.setEnabled(false);
                view.setClickable(true);//wtf??
                break;
            case ENABLED:
                view.setEnabled(true);
                view.setClickable(false);
                break;

        }

        return view;
    }

//    @Override
//    public boolean areAllItemsEnabled() {
//        return false;
//    }
}
