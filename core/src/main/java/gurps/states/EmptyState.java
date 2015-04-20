package main.java.gurps.states;

import main.java.gurps.graphics.components.MenuLink;

import java.util.ArrayList;

/**
 * Created by Caio on 15/04/2015.
 */
public class EmptyState extends State{

    private String name;
    private long bornTime;

    public EmptyState(String name) {
        this.name = name;
        this.bornTime = System.currentTimeMillis();
    }

    @Override
    public State stateDraw() {
        getFacade().drawMenuHeadings(this.getName(), new ArrayList<MenuLink>(), this);
        if(System.currentTimeMillis() - this.bornTime > 1000){
            return new MenuState();
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
