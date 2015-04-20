package main.java.gurps.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.utils.Array;
import main.java.gurps.application.Configuration;
import main.java.gurps.graphics.components.IconUploader;
import main.java.gurps.graphics.components.MenuLink;
import main.java.gurps.graphics.components.TextAreaInput;
import main.java.gurps.graphics.components.TextInput;
import main.java.gurps.graphics.listeners.HoverListener;
import main.java.gurps.states.MenuState;
import main.java.gurps.states.State;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Caio on 18/04/2015.
 */
public class GraphicsFacadeLibGDX implements GraphicsFacade {

    private static final Texture BACKGROUND = new Texture(Gdx.files.internal(Configuration.BG_REF));
    private Stage stage;
    private SpriteBatch batch = new SpriteBatch();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private BitmapFont bitmapFont;
    private BitmapFont menuFont;
    private Map<MenuLink, Label> mapLinkActor = new HashMap<MenuLink, Label>();

    private Integer height;
    private Integer width;

    
    public void drawVerticalMenu() {
        Integer width = this.getWidth();
        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_SCREEN_RATIO;
        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_SCREEN_RATIO;
        this.drawPairOfVerticalLines(0, this.getHeight(), leftBoarderLineX, rightBoarderLineX);

        Color color = this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR);
        this.drawRect(color, leftBoarderLineX, 0, rightBoarderLineX - leftBoarderLineX, this.getHeight());

    }

    private void drawRect(Color color, Float x, Integer y, float width, int height) {
        Gdx.gl.glEnable(GL11.GL_BLEND);
        Gdx.gl.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.setColor(color);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        Gdx.gl.glDisable(GL11.GL_BLEND);
    }

    private void drawPairOfVerticalLines(Integer initialY, Integer finalY, float leftBoarderLineX, float rightBoarderLineX) {
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();
        shapeRenderer.setColor(this.getColor(Configuration.MENU_BOARDER_COLOR));
        shapeRenderer.line(leftBoarderLineX, initialY, leftBoarderLineX, finalY);
        shapeRenderer.line(rightBoarderLineX, initialY, rightBoarderLineX, finalY);
        shapeRenderer.end();
    }

    private Color getColor(java.awt.Color color) {
        float max = 255f;
        return new Color(color.getRed()/max, color.getGreen()/max, color.getBlue()/max, color.getAlpha()/max);
    }

    public void drawSubVerticalMenu() {
        Integer width = this.getWidth();
        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_SCREEN_RATIO;
        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_SCREEN_RATIO;
        int height = (int) (this.getHeight() * (1 - Configuration.MENU_SUB_MENU_HEIGHT_RATIO));
        this.drawPairOfVerticalLines(this.getHeight(), height, leftBoarderLineX, rightBoarderLineX);

        shapeRenderer.begin();
        shapeRenderer.line(leftBoarderLineX, height, rightBoarderLineX, height);
        shapeRenderer.end();

        this.drawRect(this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR), leftBoarderLineX, height,
                rightBoarderLineX - leftBoarderLineX, this.getHeight());

    }

    public Integer getWidth() {
        if(this.width == null){
            this.width = Gdx.graphics.getWidth();
        }
        return this.width;
    }

    public Integer getHeight() {
        if(this.height == null){
            this.height = Gdx.graphics.getHeight();
        }
        return this.height;
    }

    public void drawBackground() {
        batch.begin();
        batch.draw(BACKGROUND, 0, 0, this.getWidth(), this.getHeight());
        batch.end();
    }

    public void drawMenuHeadings(String title, List<MenuLink> links, State state) {
        this.drawVerticalMenu();
        this.drawMenuHeadings(title, null, links, state);
    }

    public void drawMenuHeadings(String title, MenuLink backLink, List<MenuLink> links, State state) {
        int x = (int) (this.getWidth() * Configuration.MENU_HEADING_WIDTH_RATIO);
        int y = (int) (this.getHeight() * (1 - Configuration.MENU_HEADING_HEIGTH_RATIO));
        int linkWidth = Configuration.MENU_HEADING_MOUSE_OVER_AREA_WIDTH;
        int linkHeight = Configuration.MENU_HEADING_MOUSE_OVER_AREA_HEIGTH;
        int ySpace = (int) (this.getHeight() * Configuration.MENU_HEADING_HEIGTH_RATIO_SPACE);

        batch.begin();

        this.getMenuFont().draw(batch, title, x, y);

        y -= Configuration.HEADING_SPACE_MULTIPLIER * ySpace;
        if(backLink != null) {
            this.drawHeading(backLink, (int) (x + this.getWidth() * Configuration.MENU_HEADING_BACK_LINK_WIDTH_RADIO_SPACE),
                    y, linkWidth, linkHeight, state);
        }

        for(MenuLink link : links){
            y -= ySpace;
            this.drawHeading(link, x, y, linkWidth, linkHeight, state);
        }
        batch.end();
    }

    private void drawHeading(MenuLink link, int x, int y, int linkWidth, int linkHeight, State state) {
        String text = link.getText();
        Color defaultColor = this.getColor(Configuration.MENU_FONT_COLOR);
        if(!this.getMapLinkActor().containsKey(link)){
            Label label = new Label(text, new Label.LabelStyle(this.getMenuFont(), defaultColor));
            label.addListener(new HoverListener(state, link));
            label.setPosition(x, y);
            this.getStage().addActor(label);
            this.getMapLinkActor().put(link, label);
        }
        Label label = this.getMapLinkActor().get(link);
        if(link.isMouseOver()){
            label.setColor(this.getColor(Configuration.MENU_HEADING_MOUSE_OVER_COLOR));
        } else{
            label.setColor(defaultColor);
        }
//        graphics.setColor(Configuration.MENU_FONT_COLOR);
//        if(mouseOverArea.isMouseOver()) {
//            graphics.setFont(MOUSE_OVER_MENU_FONT);
//        } else{
//            graphics.setFont(DEFAULT_MENU_FONT);
//        }
//        graphics.drawString(text, x, y);
//
//        mouseOverArea = link.getMouseOverArea();
//        mouseOverArea.setNormalColor(Configuration.COLOR_TRANSPARENT);
//        mouseOverArea.setMouseOverColor(Configuration.COLOR_TRANSPARENT);
//        link.render(gameContainer, graphics);
    }

    public void drawSubMenu(String title, String subMenuTitle, MenuLink backLink, State state) {
        this.drawSubVerticalMenu();
        int x = (int) (this.getWidth() * Configuration.MENU_HEADING_WIDTH_RATIO);
        int y = (int) (this.getHeight() * (1 - Configuration.MENU_HEADING_HEIGTH_RATIO));
        int linkWidth = Configuration.MENU_HEADING_MOUSE_OVER_AREA_WIDTH;
        int linkHeight = Configuration.MENU_HEADING_MOUSE_OVER_AREA_HEIGTH;
        int ySpace = (int) (this.getHeight() * Configuration.MENU_HEADING_HEIGTH_RATIO_SPACE);

        batch.begin();

        this.getMenuFont().draw(batch, title, x, y);

        int y1 = (int) (y - Configuration.HEADING_SPACE_MULTIPLIER*ySpace);
        this.getMenuFont().draw(batch, subMenuTitle, x, y1);
        this.drawHeading(backLink, (int) (x + width * Configuration.MENU_HEADING_BACK_LINK_WIDTH_RADIO_SPACE),
                y1, linkWidth, linkHeight, state);
        batch.end();
    }

    public int drawTextAreaInput(TextAreaInput textInput, int descriptionX, int descriptionY, int descriptionWidth, State state) {
        return 0;
    }

    public int drawTextInput(TextInput textInput, int descriptionX, int descriptionY, int descriptionWidth, State state) {
        return 0;
    }

    public void drawContent(State state, Object... items) {
        Integer width = this.getWidth();
        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_CONTENT_BOX_RATIO;
        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_CONTENT_BOX_RATIO;
        Integer height = this.getHeight();
        int minY = 0;
        this.drawContentBox(leftBoarderLineX, rightBoarderLineX, height, minY);

        int initialY = minY + Configuration.CONTENT_MARGIN;
        int initialX = (int) (leftBoarderLineX + Configuration.CONTENT_MARGIN);
        int availableWidtht = (int) (rightBoarderLineX - leftBoarderLineX - Configuration.CONTENT_MARGIN * Configuration.CONTENT_MARGIN_MULTIPLIER);
        for(Object item : items){
            int itemHeight = 0;
            if(item instanceof IconUploader){
                itemHeight = this.drawIconUploader((IconUploader) item, initialX, initialY, state);
            } else if(item instanceof TextInput){
                itemHeight = this.drawTextInput((TextInput) item, initialX, initialY, availableWidtht, state);
            } else if(item  instanceof TextAreaInput){
                itemHeight = this.drawTextAreaInput((TextAreaInput) item, initialX, initialY, availableWidtht, state);
            }
//            else if(item instanceof GearTable){
//                //itemHeight = this.drawTable((GearTable) item, listener, initialX, initialY, availableWidtht);
//            }
            initialY += Configuration.CONTENT_MARGIN + itemHeight;
        }
    }

    private void drawContentBox(Float leftBoarderLineX, Float rightBoarderLineX, Integer height, int minY) {
        this.drawRect(this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR),
                leftBoarderLineX, minY, rightBoarderLineX - leftBoarderLineX, height);
        this.drawPairOfVerticalLines(minY, (int) height, leftBoarderLineX, rightBoarderLineX);
        shapeRenderer.begin();
        shapeRenderer.line(leftBoarderLineX, minY, rightBoarderLineX, minY);
        shapeRenderer.end();
    }

    public int drawIconUploader(IconUploader icon, int iconX, int iconY, State state) {
        FileChooser

//        FileChooser.setFavoritesPrefsName("com.your.package.here");
//
////chooser creation
//        fileChooser = new FileChooser(Mode.OPEN);
//        fileChooser.setSelectionMode(SelectionMode.DIRECTORIES);
//        fileChooser.setListener(new FileChooserAdapter() {
//            @Override
//            public void selected (FileHandle file) {
//                textField.setText(file.file().getAbsolutePath());
//            }
//        });
//
////button listener
//        selectFileButton.addListener(new ChangeListener() {
//            @Override
//            public void changed (ChangeEvent event, Actor actor) {
//                //displaying chooser with fade in animation
//                getStage().addActor(fileChooser.fadeIn());
//            }
//        });
        return 0;
    }

    public void beginDraw() {

    }

    public void endDraw() {
        this.getStage().act();
        this.getStage().draw();
    }

    public void quit() {
        // TODO: What should I do here?
    }

    public void clear() {
        Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
        Gdx.graphics.getGL20().glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    }

    public void clearStage() {
        this.getStage().clear();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public Map<MenuLink, Label> getMapLinkActor() {
        return mapLinkActor;
    }

    public void setMapLinkActor(Map<MenuLink, Label> mapLinkActor) {
        this.mapLinkActor = mapLinkActor;
    }

    private BitmapFont getMenuFont() {
        if(menuFont == null) {
            FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(
                    Gdx.files.classpath(Configuration.RESOURCE_DIRECTORY + Configuration.MENU_FONT_NAME));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = Configuration.MENU_FONT_SIZE;
            menuFont = freeTypeFontGenerator.generateFont(parameter);
        }
        return menuFont;
    }

    public Stage getStage() {
        if(stage == null){
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);
        }
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
