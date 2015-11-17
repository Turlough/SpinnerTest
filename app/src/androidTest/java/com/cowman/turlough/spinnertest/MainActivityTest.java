package com.cowman.turlough.spinnertest;

/**
 * Created by turlough on 14/11/15.
 */
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Spinner;
import static android.test.MoreAsserts.*;

import org.junit.After;
import org.junit.Before;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

public class MainActivityTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    Spinner fromSpinner;
    Spinner toSpinner;

    int lastItem;
    int firstItem;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
        fromSpinner = (Spinner) activity.findViewById(R.id.from_spinner);
        toSpinner = (Spinner) activity.findViewById(R.id.to_spinner);

        firstItem = 0;
        lastItem = activity.stopList.size() -1;

//        onData(hasToString(startsWith("Douglas")))
//                .inAdapterView(withId(R.id.from_spinner))
//                .perform(click());
//
//        onData(hasToString(startsWith("Town Centre")))
//                .inAdapterView(withId(R.id.to_spinner))
//                .perform(click());
    }

    @After
    public void tearDown() throws Exception{
//        onData(hasToString(startsWith("Douglas")))
//                .inAdapterView(withId(R.id.from_spinner))
//                .perform(click());
//        onData(hasToString(startsWith("Town Centre")))
//                .inAdapterView(withId(R.id.to_spinner))
//                .perform(click());
    }

    @UiThreadTest
    public void testFromSpinnerLoadsData(){

        onData(hasToString(startsWith("Blackrock")))
                .inAdapterView(withId(R.id.from_spinner))
                .perform(click());

        assertEquals("incorrect stop selected", "Blackrock", activity.getFromStop().getName());

    }

    @UiThreadTest
    public void testToSpinnerLoadsData(){

        onData(hasToString(startsWith("Blackrock")))
                .inAdapterView(withId(R.id.to_spinner))
                .perform(click());

        assertEquals("incorrect stop selected", "Blackrock", activity.getToStop().getName());

    }

    @UiThreadTest
    public void testFromSpinnerLastDisabled(){

        onData(anything())
                .inAdapterView(withId(R.id.from_spinner))
                .atPosition(lastItem)
                .check(matches(not(isEnabled())));

    }

    @UiThreadTest
    public void testToSpinnerFirstDisabled(){
        onData(anything())
                .inAdapterView(withId(R.id.to_spinner))
                .atPosition(0)
                .check(matches(not(isEnabled())));

    }

    @UiThreadTest
    public void testToSpinnerLastSelected(){

        onData(anything())
                .inAdapterView(withId(R.id.to_spinner))
                .atPosition(lastItem)
                .check(matches(isSelected()));

    }

    @UiThreadTest
    public void testFromSpinnerDisablesStartOfToSpinner(){

//        onData(anything())
//                .inAdapterView(withId(R.id.from_spinner))
//                .atPosition(2)
//                .perform(click());
        onData(anything())
                .inAdapterView(withId(R.id.to_spinner))
                .atPosition(2)
                .check(matches(not(isEnabled())));

        onData(anything())
                .inAdapterView(withId(R.id.to_spinner))
                .atPosition(2)
                .check(matches(isEnabled()));

        onData(anything())
                .inAdapterView(withId(R.id.to_spinner))
                .atPosition(3)
                .check(matches(isEnabled()));

//        onView(allOf(withText("Douglas"), withId(R.id.to_spinner)))
//                .check(matches(isEnabled()));
//
//        onView(withText("Blackrock"))
//                .check(matches(not(isEnabled())));
//
//        onView(withText("Victoria Road"))
//                .check(matches(not(isEnabled())));

    }

}