package main.java.gurps.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.file.FileChooser;
import main.java.gurps.application.Configuration;
import main.java.gurps.graphics.components.IconUploader;
import main.java.gurps.graphics.components.MenuLink;
import main.java.gurps.graphics.components.TextAreaInput;
import main.java.gurps.graphics.components.TextInput;
import main.java.gurps.graphics.listeners.SuperListener;
import main.java.gurps.states.State;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Caio on 18/04/2015.
 */
public class GraphicsFacadeLibGDX extends ClickListener implements GraphicsFacade {

    private static final Texture BACKGROUND = new Texture(Gdx.files.internal(Configuration.BG_REF));
    private Stage stage;
    private SpriteBatch batch = new SpriteBatch();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private BitmapFont bitmapFont;
    private BitmapFont menuFont, smallMenuFont;
    private Map<MenuLink, Label> mapLinkActor = new HashMap<MenuLink, Label>();
    private Map<IconUploader, FileChooser> mapFileChooser = new HashMap<IconUploader, FileChooser>();
    private Map<IconUploader, Label> mapFileChooserLabel = new HashMap<IconUploader, Label>();
    private Map<TextInput, TextField> mapTextInputField = new HashMap<TextInput, TextField>();


    private Integer height;
    private Integer width;

    
    public void drawVerticalMenu() {
        Integer width = this.getWidth();
        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_SCREEN_RATIO;
        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_SCREEN_RATIO;
        this.drawPairOfVerticalLines(0, this.getHeight(), leftBoarderLineX, rightBoarderLineX);

        Color color = this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR);
        this.drawRect(color, leftBoarderLineX, 0f, rightBoarderLineX - leftBoarderLineX, this.getHeight());

    }

    private void drawRect(Color color, float x, float y, float width, float height) {
        Gdx.gl.glEnable(GL11.GL_BLEND);
        Gdx.gl.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        shapeRenderer.setColor(color);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        Gdx.gl.glDisable(GL11.GL_BLEND);
    }

    private void drawPairOfVerticalLines(float initialY, float finalY, float leftBoarderLineX, float rightBoarderLineX) {
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

        this.drawRect(this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR), leftBoarderLineX, new Float(height),
                rightBoarderLineX - leftBoarderLineX, new Float(this.getHeight()));

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
            label.addListener(new SuperListener(state, link));
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
        Integer inputHeight = Configuration.TEXT_INPUT_HEIGTH;
        if(!this.getMapTextInputField().containsKey(textInput)){
            TextField.TextFieldStyle style = new TextField.TextFieldStyle();
            style.fontColor = this.getColor(Configuration.TEXT_INPUT_TEXT_COLOR);
            style.font = this.getSmallMenuFont();
            TextField textField = new TextField(textInput.getInitialValue(), style);
            textField.setPosition(descriptionX, descriptionY - inputHeight);
            textField.setWidth(descriptionWidth);
            textField.setMaxLength(Configuration.TEXT_INPUT_MAX_LENGTH);
            textField.setHeight(inputHeight);
            this.getStage().addActor(textField);
            this.getMapTextInputField().put(textInput, textField);
        }
        batch.begin();
        this.drawRect(this.getColor(Configuration.TEXT_INPUT_BACKGROUND_COLOR), descriptionX, descriptionY - inputHeight,
                descriptionWidth, inputHeight);
        batch.end();
        TextField textField = this.getMapTextInputField().get(textInput);
        return inputHeight;
    }

    public void drawContent(State state, Object... items) {
        Integer width = this.getWidth();
        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_CONTENT_BOX_RATIO;
        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_CONTENT_BOX_RATIO;
        Integer height = this.getHeight();
        int minY = 0;
        this.drawContentBox(leftBoarderLineX, rightBoarderLineX, height, minY);

        int initialY = minY + height - Configuration.CONTENT_MARGIN;
        int initialX = (int) (leftBoarderLineX + Configuration.CONTENT_MARGIN);
        int availableWidth = (int) (rightBoarderLineX - leftBoarderLineX - Configuration.CONTENT_MARGIN * Configuration.CONTENT_MARGIN_MULTIPLIER);
        for(Object item : items){
            int itemHeight = 0;
            if(item instanceof IconUploader){
                itemHeight = this.drawIconUploader((IconUploader) item, initialX, initialY, state);
            } else if(item instanceof TextInput){
                itemHeight = this.drawTextInput((TextInput) item, initialX, initialY, availableWidth, state);
            } else if(item  instanceof TextAreaInput){
                itemHeight = this.drawTextAreaInput((TextAreaInput) item, initialX, initialY, availableWidth, state);
            }
//            else if(item instanceof GearTable){
//                //itemHeight = this.drawTable((GearTable) item, listener, initialX, initialY, availableWidth);
//            }
            initialY = initialY - Configuration.CONTENT_MARGIN - itemHeight;
        }
    }

    private void drawContentBox(float leftBoarderLineX, float rightBoarderLineX, float height, float minY) {
        this.drawRect(this.getColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR),
                leftBoarderLineX, minY, rightBoarderLineX - leftBoarderLineX, height);
        this.drawPairOfVerticalLines(minY, height, leftBoarderLineX, rightBoarderLineX);
        shapeRenderer.begin();
        shapeRenderer.line(leftBoarderLineX, minY, rightBoarderLineX, minY);
        shapeRenderer.end();
    }

    public int drawIconUploader(IconUploader icon, int iconX, int iconY, State state) {
        Integer iconWidth = Configuration.ICON_UPLOADER_WIDTH;
        Integer iconHeight = Configuration.ICON_UPLOADER_HEIGTH;
        if(!this.getMapFileChooser().containsKey(icon)) {
            VisUI.load(Gdx.files.internal("core/src/main/resources/ui_skin_raw/uiskin.json"));
            FileChooser fc = new FileChooser(FileChooser.Mode.OPEN);
            fc.setSelectionMode(FileChooser.SelectionMode.FILES);
            fc.setListener(new SuperListener(state, icon));
            fc.setPosition(iconX, iconY - iconHeight);
            fc.setHeight(Configuration.FILE_CHOOSER_HEIGTH);
            fc.setWidth(Configuration.FILE_CHOOSER_WIDTH);
            this.getMapFileChooser().put(icon, fc);
            //this.getStage().addActor(fc);
        }
        if(!this.getMapFileChooserLabel().containsKey(icon)){
            Label.LabelStyle style = new Label.LabelStyle(this.getSmallMenuFont(), this.getColor(Configuration.ICON_LABEL_COLOR));
            Label label = new Label(main.java.gurps.application.Label.ADD_ICON_MESSAGE,
                    style);
            label.setWrap(true);
            label.setSize(iconWidth, iconHeight);
            int value = BitmapFont.HAlignment.CENTER.ordinal();
            label.setAlignment(value, value);
            label.addListener(this);
            this.getMapFileChooserLabel().put(icon, label);
            label.setPosition(iconX, iconY - iconHeight);
            this.getStage().addActor(label);
        }
        if(icon.getFile()!=null){
            batch.begin();
            Texture texture = new Texture(new FileHandle(icon.getFile()));
            batch.draw(texture, iconX, iconY, iconWidth, iconHeight);
            batch.end();
            Label label = this.getMapFileChooserLabel().get(icon);
            label.setPosition(iconX + iconWidth, iconY - iconHeight);
            label.setText(main.java.gurps.application.Label.CHANGE_ICON_MESSAGE);
        } else{
            batch.begin();
            this.drawRect(this.getColor(Configuration.ICON_BACKGROUND_COLOR), iconX, iconY - iconHeight, iconWidth, iconHeight);
            batch.end();
        }

        return iconHeight;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        for (Map.Entry<IconUploader, Label> entry : this.getMapFileChooserLabel().entrySet()) {
            if(entry.getValue().equals(event.getTarget())){
                this.getStage().addActor(this.getMapFileChooser().get(entry.getKey()).fadeIn());
            }
        }

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
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
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

    private BitmapFont getSmallMenuFont() {
        if(smallMenuFont == null) {
            FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(
                    Gdx.files.classpath(Configuration.RESOURCE_DIRECTORY + Configuration.MENU_FONT_NAME));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = Configuration.SMALL_MENU_FONT_SIZE;
            smallMenuFont = freeTypeFontGenerator.generateFont(parameter);
        }
        return smallMenuFont;
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

    public Map<IconUploader, FileChooser> getMapFileChooser() {
        return mapFileChooser;
    }

    public void setMapFileChooser(Map<IconUploader, FileChooser> mapFileChooser) {
        this.mapFileChooser = mapFileChooser;
    }

    public Map<IconUploader, Label> getMapFileChooserLabel() {
        return mapFileChooserLabel;
    }

    public void setMapFileChooserLabel(Map<IconUploader, Label> mapFileChooserLabel) {
        this.mapFileChooserLabel = mapFileChooserLabel;
    }

    public Map<TextInput, TextField> getMapTextInputField() {
        return mapTextInputField;
    }

    public void setMapTextInputField(Map<TextInput, TextField> mapTextInputField) {
        this.mapTextInputField = mapTextInputField;
    }
}

