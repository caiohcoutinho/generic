package main.java.gurps.states.universe;

import main.java.gurps.application.Label;
import main.java.gurps.graphics.GraphicsFacade;
import main.java.gurps.graphics.components.MenuLink;
import main.java.gurps.states.MenuState;
import main.java.gurps.states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caio on 15/04/2015.
 */
public class UniverseState extends State {

    private String title;
    private List<MenuLink> links;
    private MenuLink back;
    private State nextState;


    public UniverseState() {
        this.setTitle(Label.UNIVERSE);
        List<MenuLink> links = new ArrayList<MenuLink>();
        for(String link : new String[]{
                Label.ADVANTAGES,
                Label.DISADVANTAGES,
                Label.SKILLS,
                Label.MAGICS,
                Label.GEAR,
                Label.STATUS,
                Label.CONDITIONS,
                Label.RACES,
        }){
            MenuLink menulink = new MenuLink(link);
            links.add(menulink);
        }
        this.setLinks(links);
        this.setBack(new MenuLink(Label.BACK));

    }

    @Override
    public State stateDraw() {
        GraphicsFacade facade = getFacade();
        facade.drawBackground();
        facade.drawVerticalMenu();
        facade.drawMenuHeadings(this.getTitle(), this.getBack(), this.getLinks(), this);
        if(this.getNextState() != null){
            facade.clearStage();
            return this.getNextState();
        }
        return this;
    }

    @Override
    public void clicked(Object originalComponent) {
        if(this.getBack().equals(originalComponent)){
            this.setNextState(new MenuState());
        } else {
            for (MenuLink link : this.getLinks()) {
                if (link.getText().equals(Label.GEAR)) {
                    this.setNextState(new UniverseGearState());
                    break;
                }
            }
        }
    }

    @Override
    public void enter(Object originalComponent) {
        MenuLink back = this.getBack();
        if(originalComponent.equals(back)){
            back.setIsMouseOver(true);
        } else {
            for (MenuLink link : this.getLinks()) {
                if (link.equals(originalComponent)) {
                    link.setIsMouseOver(true);
                    break;
                }
            }
        }
    }

    @Override
    public void exit(Object originalComponent) {
        MenuLink back = this.getBack();
        if(originalComponent.equals(back)){
            back.setIsMouseOver(false);
        } else {
            for (MenuLink link : this.getLinks()) {
                if (link.equals(originalComponent)) {
                    link.setIsMouseOver(false);
                    break;
                }
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuLink> getLinks() {
        return links;
    }

    public void setLinks(List<MenuLink> links) {
        this.links = links;
    }

    public MenuLink getBack() {
        return back;
    }

    public void setBack(MenuLink back) {
        this.back = back;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
