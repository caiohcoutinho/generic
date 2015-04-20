package main.java.gurps.graphics.listeners;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import main.java.gurps.application.Label;
import main.java.gurps.graphics.components.IconUploader;
import main.java.gurps.graphics.components.MenuLink;
import main.java.gurps.states.State;
import net.dermetfan.gdx.scenes.scene2d.ui.FileChooser;

import java.io.File;
import java.util.Map;

/**
 * Created by Naiara on 19/04/2015.
 */
public class HoverListener extends ClickListener implements FileChooser.Listener {

    private State state;
    private Object originalComponent;

    public HoverListener(State state, Object originalComponent) {
        this.state = state;
        this.originalComponent = originalComponent;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        this.getState().clicked(this.getOriginalComponent());
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        this.getState().enter(this.getOriginalComponent());
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        this.getState().exit(this.getOriginalComponent());
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Object getOriginalComponent() {
        return originalComponent;
    }

    public void setOriginalComponent(Object originalComponent) {
        this.originalComponent = originalComponent;
    }

    public void choose(FileHandle fileHandle) {
        if(originalComponent instanceof IconUploader){
            ((IconUploader) originalComponent).setFile(fileHandle.file());
        } else{
            throw new RuntimeException("Um componente que não era um IconUploader foi chamado para adicionar arquivo.");
        }
    }

    public void choose(Array<FileHandle> array) {
        throw new UnsupportedOperationException();
    }
}
