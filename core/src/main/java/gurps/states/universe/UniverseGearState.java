package main.java.gurps.states.universe;

import com.badlogic.gdx.Gdx;
import main.java.gurps.application.Label;
import main.java.gurps.graphics.GraphicsFacade;
import main.java.gurps.graphics.components.*;
import main.java.gurps.states.State;

/**
 * Created by Caio on 15/04/2015.
 */
public class UniverseGearState extends State {

    private String title;
    private String subMenuTitle;
    private MenuLink backLink;
    private State nextState;
    private TextInput name;
    private IconUploader icon;
    private TextInput description;
    private int counter;

    public UniverseGearState() {
        this.title = Label.UNIVERSE;
        this.subMenuTitle = Label.GEAR;
        this.backLink = new MenuLink(Label.BACK);
        this.name = new TextInput(Label.GEAR_NAME, Label.GEAR_NAME);
        this.icon = new IconUploader();
        this.description = new TextInput(Label.GEAR_DESCRIPTION, Label.GEAR_DESCRIPTION); // TODO: Usar TextArea
    }

    @Override
    public State stateDraw() {
        GraphicsFacade facade = getFacade();
        facade.drawBackground();

        facade.drawSubMenu(this.getTitle(), this.getSubMenuTitle(), this.getBackLink(), this);
        facade.drawContent(this, this.getIcon(), this.getName(), this.getDescription());

        this.getName().react();
        this.getDescription().react();
        if(this.getNextState() != null){
            facade.clearStage();
            return this.getNextState();
        }
        return this;
    }

    @Override
    public void enter(Object originalComponent) {
        MenuLink backLink = this.getBackLink();
        if(originalComponent.equals(backLink)){
            backLink.setIsMouseOver(true);
        }
    }

    @Override
    public void exit(Object originalComponent) {
        MenuLink backLink = this.getBackLink();
        if(originalComponent.equals(backLink)){
            backLink.setIsMouseOver(false);
        }
    }

    @Override
    public void clicked(Object originalComponent) {
        if(originalComponent.equals(this.getBackLink())){
            this.setNextState(new UniverseState());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubMenuTitle() {
        return subMenuTitle;
    }

    public void setSubMenuTitle(String subMenuTitle) {
        this.subMenuTitle = subMenuTitle;
    }

    public MenuLink getBackLink() {
        return backLink;
    }

    public void setBackLink(MenuLink backLink) {
        this.backLink = backLink;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public TextInput getName() {
        return name;
    }

    public void setName(TextInput name) {
        this.name = name;
    }


    public IconUploader getIcon() {
        return icon;
    }

    public void setIcon(IconUploader icon) {
        this.icon = icon;
    }

    public TextInput getDescription() {
        return description;
    }

    public void setDescription(TextInput description) {
        this.description = description;
    }

}
