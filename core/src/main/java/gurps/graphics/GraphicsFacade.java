package main.java.gurps.graphics;

import main.java.gurps.graphics.components.*;
import main.java.gurps.states.MenuState;
import main.java.gurps.states.State;

import java.util.List;

/**
 * Created by Caio on 18/04/2015.
 */
public interface GraphicsFacade {

    void drawVerticalMenu();

    void drawSubVerticalMenu();

    Integer getWidth();

    Integer getHeight();

    void drawBackground();

    void drawMenuHeadings(String title, List<MenuLink> links, State state);

    void drawMenuHeadings(String title, MenuLink backLink, List<MenuLink> links, State state);

    void drawSubMenu(String title, String subMenuTitle, MenuLink backLink, State state);

    int drawTextAreaInput(TextAreaInput textInput, int descriptionX, int descriptionY,
            int descriptionWidth, State state);

    int drawTextInput(TextInput textInput, int descriptionX, int descriptionY,
            int descriptionWidth, State state);

    void drawContent(State state, Object... items);

    int drawIconUploader(IconUploader icon, int iconX, int iconY, State state);

    void beginDraw();

    void endDraw();

    void quit();

    void clear();

    void clearStage();
}
