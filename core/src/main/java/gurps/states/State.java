package main.java.gurps.states;


import main.java.gurps.graphics.GraphicsFacade;
import main.java.gurps.graphics.GraphicsFacadeLibGDX;

/**
 * Created by Caio on 14/04/2015.
 */
public abstract class State{

    protected static final GraphicsFacade facade = new GraphicsFacadeLibGDX();

    public static GraphicsFacade getFacade() {
        return facade;
    }

    public abstract State stateDraw();

    public State draw(){
        GraphicsFacade facade = this.getFacade();
        facade.clear();
        facade.beginDraw();
//        if(facade.getGameContainer() == null || facade.getGraphics() == null) {
//            facade.setGameContainer(gc);
//            facade.setGraphics(g);
//            try {
//                RootPane root = new RootPane();
//                LWJGLRenderer renderer = new LWJGLRenderer();
//                renderer.setUseSWMouseCursors(true);
//                GearTable child = new GearTable();
//                child.setPosition(200,200);
//                child.setSize(200,800);
//                root.desk.add(child);
//                child.adjustSize();
//
//                GUI gui = new GUI(root, renderer);
//                gui.applyTheme(ThemeManager.createThemeManager(getClass().getClassLoader().getResource(
//                        "themes/simple_demo.xml"), renderer));
//                facade.setGui(gui);
//            } catch (LWJGLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        State state = this.stateDraw();
        facade.endDraw();
        return state;
    }

    public void enter(Object originalComponent){

    }

    public void exit(Object originalComponent){

    }

    public void quit(){
        this.getFacade().quit();
    }

    public void clicked(Object originalComponent){

    }
}
