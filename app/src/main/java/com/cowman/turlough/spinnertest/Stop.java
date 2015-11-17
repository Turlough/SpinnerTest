package com.cowman.turlough.spinnertest;

/**
 * Created by turlough on 14/11/15.
 */
public class Stop {

    enum State {
        ENABLED,
        DISABLED,
        SELECTED
    }

    private int id;
    private int index;
    private String name;
    private State state;

    public Stop(int id, int index, String name) {
        this.id = id;
        this.index = index;
        this.name = name;
        this.state= State.ENABLED;
    }

    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return name;
    }
}
