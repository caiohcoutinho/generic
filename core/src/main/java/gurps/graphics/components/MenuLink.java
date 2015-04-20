package main.java.gurps.graphics.components;


/**
 * Created by Caio on 14/04/2015.
 */
public class MenuLink {

    private String text;
    private float x, y, width, height;
    private boolean isMouseOver;

    public MenuLink(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMouseOver() {
        return isMouseOver;
    }

    public void setIsMouseOver(boolean isMouseOver) {
        this.isMouseOver = isMouseOver;
    }
}

