package main.java.gurps.model;

import java.util.List;

/**
 * Created by Caio on 17/04/2015.
 */
public class Reach {
    private List<Integer> reaches;

    public Reach(List<Integer> reaches) {
        this.reaches = reaches;
    }

    public List<Integer> getReaches() {
        return reaches;
    }

    public void setReaches(List<Integer> reaches) {
        this.reaches = reaches;
    }
}
