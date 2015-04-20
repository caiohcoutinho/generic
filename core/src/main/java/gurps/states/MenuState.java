package main.java.gurps.states;

import com.badlogic.gdx.Gdx;
import main.java.gurps.application.Label;
import main.java.gurps.graphics.GraphicsFacade;
import main.java.gurps.graphics.components.MenuLink;
import main.java.gurps.states.universe.UniverseState;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Caio on 14/04/2015.
 */
public class MenuState extends State{

    private static final Logger LOGGER = Logger.getLogger(MenuState.class.getName());

    private String title;
    private List<MenuLink> links;
    private State nextState;

    public MenuState(){
        this.setTitle(Label.GAME_TITLE);
        List<MenuLink> links = new ArrayList<MenuLink>();
        for(String link : new String[]{Label.PLAY, Label.CHARACTER,
                Label.UNIVERSE, Label.CAMPAIGN, Label.CONFIGURATION, Label.EXIT}){
            links.add(new MenuLink(link));
        }
        this.setLinks(links);
    }

    public State stateDraw() {
        GraphicsFacade facade = getFacade();
        facade.drawBackground();
        facade.drawMenuHeadings(this.getTitle(), this.getLinks(), this);
        if(this.getNextState() == null){
            return this;
        }
        facade.clearStage();
        return this.getNextState();
    }

    @Override
    public void clicked(Object originalComponent) {
        for(MenuLink link : this.getLinks()){
            if (link.equals(originalComponent)) {
                String text = link.getText();
                if(text.equals(Label.UNIVERSE)){
                    this.setNextState(new UniverseState());
                    break;
                } else if(text.equals(Label.EXIT)){
                    Gdx.app.exit();
                }
            }
        }
    }

    @Override
    public void enter(Object originalComponent) {
        for(MenuLink link : this.getLinks()){
            if (link.equals(originalComponent)) {
                link.setIsMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void exit(Object originalComponent) {
        for(MenuLink link : this.getLinks()){
            if (link.equals(originalComponent)) {
                link.setIsMouseOver(false);
                break;
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

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

}
