package com.cowman.turlough.spinnertest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends Activity {

    Spinner fromSpinner;
    Spinner toSpinner;

    StopAdapter fromAdapter;
    StopAdapter toAdapter;
    private Context context;

    StopList stopList = new StopList();

    private Stop fromStop;
    private Stop toStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        addSpinners();
        fromSpinner.setSelection(0);
        toSpinner.setSelection(stopList.size() - 1);
    }

    private void addSpinners() {
        fromSpinner = (Spinner) findViewById(R.id.from_spinner);
        fromAdapter = new StopAdapter(context, android.R.layout.simple_list_item_1, stopList.getStops());
        fromSpinner.setAdapter(fromAdapter);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!view.isEnabled())
                    return;
                fromStop = fromAdapter.getStop(position);
                toAdapter.disableTop(position + 1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toSpinner = (Spinner) findViewById(R.id.to_spinner);
        toAdapter = new StopAdapter(context, android.R.layout.simple_list_item_1, stopList.getStops());
        toSpinner.setAdapter(toAdapter);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!view.isEnabled())
                    return;
                toStop = toAdapter.getStop(position);
                fromAdapter.disableBottom(position - 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public Stop getFromStop() {
        return fromStop;
    }

    public Stop getToStop() {
        return toStop;
    }
}
