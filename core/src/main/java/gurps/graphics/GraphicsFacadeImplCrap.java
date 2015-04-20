//package main.java.gurps.graphics;
//
//import main.java.gurps.application.Configuration;
//import main.java.gurps.graphics.components.*;
//
//import java.awt.*;
//import java.util.List;
//import java.util.logging.Logger;
//
///**
// * Created by Caio on 14/04/2015.
// */
//public class GraphicsFacadeImplCrap implements GraphicsFacade{
//
//    private static final Logger LOGGER = Logger.getLogger(GraphicsFacadeImplCrap.class.getName());
//    private static final Font DEFAULT_MENU_FONT = null;
//    private static final Font DEFAULT_FIELD_FONT = null;
//    private static final Font MOUSE_OVER_MENU_FONT = null;
//    private Integer width;
//    private Integer height;
//    private boolean indo = true;
////    private static final Font DEFAULT_MENU_FONT = new TrueTypeFont(new java.awt.Font(Configuration.MENU_FONT_NAME,
////            Configuration.MENU_FONT_STYLE, Configuration.MENU_FONT_SIZE), false);
////    private static final Font DEFAULT_FIELD_FONT = new TrueTypeFont(new java.awt.Font(Configuration.FIELD_FONT_NAME,
////            Configuration.FIELD_FONT_STYLE, Configuration.FIELD_FONT_SIZE), false);
////    private static final Font MOUSE_OVER_MENU_FONT = new TrueTypeFont(new java.awt.Font(Configuration.MENU_FONT_NAME,
////            Configuration.MENU_FONT_MOUSE_OVER_STYLE, Configuration.MENU_MOUSE_OVER_FONT_SIZE), false);
//    private Image BGImage;
//
//    private boolean done = false;
//
//    public GraphicsFacadeImplCrap() {
//    }
//
//    public void drawVerticalMenu() {
//        Integer width = this.getWidth();
//        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_SCREEN_RATIO;
//        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_SCREEN_RATIO;
//        this.drawPairOfVerticalLines(0, this.getHeight(), leftBoarderLineX, rightBoarderLineX);
//
//        //graphics.setColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR);
//        //graphics.fillRect(leftBoarderLineX, 0, rightBoarderLineX - leftBoarderLineX, this.getHeight());
//    }
//
//    public void drawSubVerticalMenu() {
////        Integer width = this.getWidth();
////        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_SCREEN_RATIO;
////        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_SCREEN_RATIO;
////        int height = (int) (this.getHeight() * Configuration.MENU_SUB_MENU_HEIGHT_RATIO);
////        this.drawPairOfVerticalLines(0, height, leftBoarderLineX, rightBoarderLineX);
//        //graphics.drawLine(leftBoarderLineX, height, rightBoarderLineX, height);
//
//        //graphics.setColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR);
//       // graphics.fillRect(leftBoarderLineX, 0, rightBoarderLineX - leftBoarderLineX, height);
//    }
//
//    private void drawPairOfVerticalLines(Integer initialY, Integer finalY, float leftBoarderLineX, float rightBoarderLineX) {
//        // Set color
////        Graphics graphics = this.getGraphics();
////        graphics.setColor(Configuration.MENU_BOARDER_COLOR);
//
//        // Draw left boarder line
//        //graphics.drawLine(leftBoarderLineX, initialY, leftBoarderLineX, finalY);
//
//        // Draw right boarder line
//        //graphics.drawLine(rightBoarderLineX, initialY, rightBoarderLineX, finalY);
//    }
//
//    public Integer getWidth() {
////        if(this.width == null){
////            this.width = this.getGameContainer().getWidth();
////        }
//        return this.width;
//    }
//
//    public Integer getHeight() {
////        if(this.height == null){
////            this.height = this.getGameContainer().getHeight();
////        }
//        return this.height;
//    }
//
//    public void drawBackground() {
////        this.getBGImage().draw(0, 0, this.getWidth(), this.getHeight());
//    }
//
//    public void drawMenuHeadings(String title, List<MenuLink> links){
//        //this.drawVerticalMenu();
//        //this.drawMenuHeadings(listener, title, null, links);
//    }
//
//    public void drawMenuHeadings(String title, MenuLink backLink, List<MenuLink> links){
////        if(title == null && (links == null || links.isEmpty())){
////            LOGGER.warning("attempt to draw empty links list");
////        } else{
////            Graphics graphics = this.getGraphics();
////            GameContainer gameContainer = this.getGameContainer();
////            int x = (int) (width * Configuration.MENU_HEADING_WIDTH_RATIO);
////            int y = (int) (width * Configuration.MENU_HEADING_HEIGTH_RATIO);
////            int linkWidth = Configuration.MENU_HEADING_MOUSE_OVER_AREA_WIDTH;
////            int linkHeight = Configuration.MENU_HEADING_MOUSE_OVER_AREA_HEIGTH;
////            int ySpace = (int) (height * Configuration.MENU_HEADING_HEIGTH_RATIO_SPACE);
////
////            graphics.setFont(DEFAULT_MENU_FONT);
////
////            graphics.setColor(Configuration.MENU_FONT_COLOR);
////            graphics.drawString(title, x, y);
////
////            if(backLink != null) {
////                this.drawHeading(backLink, (int) (x + width * Configuration.MENU_HEADING_BACK_LINK_WIDTH_RADIO_SPACE),
////                        y, linkWidth, linkHeight, listener);
////            }
////            y += ySpace;
////
////            for(MenuLink link : links){
////                y += ySpace;
////                this.drawHeading(link, x, y, linkWidth, linkHeight, listener);
////            }
////        }
//    }
//
//    private void drawHeading(MenuLink link, int x, int y, int linkWidth, int linkWeight) {
////        if(link.getMouseOverArea() == null){
////            link.setMouseOverArea(new MouseOverArea(this.getGameContainer(),
////                    null, x, y, linkWidth, linkWeight, listener));
////        }
////        MouseOverArea mouseOverArea = link.getMouseOverArea();
////        String text = link.getText();
////        graphics.setColor(Configuration.MENU_FONT_COLOR);
////        if(mouseOverArea.isMouseOver()) {
////            graphics.setFont(MOUSE_OVER_MENU_FONT);
////        } else{
////            graphics.setFont(DEFAULT_MENU_FONT);
////        }
////        graphics.drawString(text, x, y);
////
////        mouseOverArea = link.getMouseOverArea();
////        mouseOverArea.setNormalColor(Configuration.COLOR_TRANSPARENT);
////        mouseOverArea.setMouseOverColor(Configuration.COLOR_TRANSPARENT);
////        link.render(gameContainer, graphics);
//    }
//
//    public void drawSubMenu(String title, String subMenuTitle, MenuLink backLink) {
////        this.drawSubVerticalMenu();
////        Graphics graphics = this.getGraphics();
////        GameContainer gameContainer = this.getGameContainer();
////        int x = (int) (width * Configuration.MENU_HEADING_WIDTH_RATIO);
////        int y = (int) (width * Configuration.MENU_HEADING_HEIGTH_RATIO);
////        int linkWidth = Configuration.MENU_HEADING_MOUSE_OVER_AREA_WIDTH;
////        int linkHeight = Configuration.MENU_HEADING_MOUSE_OVER_AREA_HEIGTH;
////        int ySpace = (int) (height * Configuration.MENU_HEADING_HEIGTH_RATIO_SPACE);
////
////        graphics.setFont(DEFAULT_MENU_FONT);
////
////        graphics.setColor(Configuration.MENU_FONT_COLOR);
////        graphics.drawString(title, x, y);
////        int y1 = (int) (y + Configuration.HEADING_SPACE_MULTIPLIER*ySpace);
////        graphics.drawString(subMenuTitle, x, y1);
////        this.drawHeading(backLink, (int) (x + width * Configuration.MENU_HEADING_BACK_LINK_WIDTH_RADIO_SPACE),
////                y1, linkWidth, linkHeight, listener);
//
//
//    }
//
//    public int drawTextAreaInput(TextAreaInput textInput, int descriptionX, int descriptionY,
//            int descriptionWidth) {
//        return drawBaseTextInput(textInput, descriptionX, descriptionY, descriptionWidth, Configuration.TEXT_AREA_INPUT_MAX_LENGTH,
//                Configuration.TEXT_AREA_INPUT_HEIGTH);
//    }
//
//    private int drawBaseTextInput(BaseTextField textInput, int descriptionX, int descriptionY,
//            int descriptionWidth, int maxLength, int descriptionHeight) {
////        Font font = DEFAULT_FIELD_FONT;
////        String fieldName = textInput.getFieldName();
////        graphics.setFont(font);
////        int labelHeight = font.getHeight(fieldName);
////        int descriptionOffset = labelHeight + Configuration.FIELD_LABEL_SPACE;
////        if(textInput.getTextField() == null) {
////            textInput.setTextField(new TextField(this.getGameContainer(), font, descriptionX,
////                    descriptionY + descriptionOffset,
////                    descriptionWidth, descriptionHeight, listener));
////            textInput.getTextField().setMaxLength(maxLength);
////        }
////        graphics.setColor(Configuration.LABEL_TEXT_COLOR);
////        graphics.drawString(fieldName,
////                (int) descriptionX,
////                (int) descriptionY);
////
////        graphics.setColor(Configuration.TEXT_INPUT_BACKGROUND_COLOR);
////        TextField textField = textInput.getTextField();
////        textField.setTextColor(Configuration.TEXT_INPUT_TEXT_COLOR);
////        textField.setBackgroundColor(Configuration.TEXT_INPUT_BACKGROUND_COLOR);
////        textField.render(this.getGameContainer(), this.getGraphics());
////
////        return descriptionHeight + descriptionOffset;
//        return 0;
//    }
//
//    public int drawTextInput(TextInput textInput, int descriptionX, int descriptionY,
//            int descriptionWidth) {
//        return drawBaseTextInput(textInput, descriptionX, descriptionY, descriptionWidth, Configuration.TEXT_INPUT_MAX_LENGTH,
//                Configuration.FIELD_HEIGTH);
//    }
//
//    public void drawContent(Object... items) {
////        Integer width = this.getWidth();
////        Float leftBoarderLineX = width * Configuration.MENU_LEFT_BOARDER_CONTENT_BOX_RATIO;
////        Float rightBoarderLineX = width * Configuration.MENU_RIGHT_BOARDER_CONTENT_BOX_RATIO;
////        Integer height = this.getHeight();
////        int minY = 0;
////        this.drawContentBox(leftBoarderLineX, rightBoarderLineX, height, minY);
////
////        int initialY = minY + Configuration.CONTENT_MARGIN;
////        int initialX = (int) (leftBoarderLineX + Configuration.CONTENT_MARGIN);
////        int availableWidtht = (int) (rightBoarderLineX - leftBoarderLineX - Configuration.CONTENT_MARGIN * Configuration.CONTENT_MARGIN_MULTIPLIER);
////        for(Object item : items){
////            int itemHeight = 0;
////            if(item instanceof IconUploader){
////                itemHeight = this.drawIconUploader((IconUploader) item, listener, initialX, initialY);
////            } else if(item instanceof TextInput){
////                itemHeight = this.drawTextInput((TextInput) item, listener, initialX, initialY, availableWidtht);
////            } else if(item  instanceof TextAreaInput){
////                itemHeight = this.drawTextAreaInput((TextAreaInput) item, listener, initialX, initialY, availableWidtht);
////            } else if(item instanceof GearTable){
////                itemHeight = this.drawTable((GearTable) item, listener, initialX, initialY, availableWidtht);
////            }
////            initialY += Configuration.CONTENT_MARGIN + itemHeight;
////        }
//    }
//
//    private int drawTable(int initialX, int initialY, int availableWidtht) {
//        //gui.setPosition(initialX, initialX);
////        if(false){
////            done = true;
////            Container frame = new Container();
////            frame.add(item);
////            gui.getRootPane().add(frame);
////            frame.adjustSize();
////            frame.setPosition(initialX, initialY);
////        }
////        //item.setPosition(initialX, initialX);
////        item.setMaxSize(Configuration.TABLE_MAX_HEIGHT, availableWidtht);
////        gui.draw();
//       // return item.getHeight();
//        return 0;
//    }
//
//    private void drawContentBox(float leftBoarderLineX, float rightBoarderLineX, float boxHeight, Integer minY) {
////        graphics.setColor(Configuration.MENU_TRANSPARENT_BACKGROUND_COLOR);
////        graphics.fillRect(leftBoarderLineX, minY, rightBoarderLineX - leftBoarderLineX, boxHeight);
////        this.drawPairOfVerticalLines(minY, (int) boxHeight, leftBoarderLineX, rightBoarderLineX);
////        graphics.drawLine(leftBoarderLineX, minY, rightBoarderLineX, minY);
//    }
//
//    public void quit() {
//        //this.getGameContainer().exit();
//    }
//
//    public int drawIconUploader(IconUploader icon, int iconX, int iconY) {
////        graphics.setFont(DEFAULT_FIELD_FONT);
////        Integer iconWidth = Configuration.ICON_UPLOADER_WIDTH;
////        Integer iconHeight = Configuration.ICON_UPLOADER_HEIGTH;
////        if(icon.getMouseOverArea() == null) {
////            icon.setMouseOverArea(new MouseOverArea(this.getGameContainer(),
////                    null, iconX, iconY, iconWidth, iconHeight, listener));
////            MouseOverArea mouseOverArea = icon.getMouseOverArea();
////            mouseOverArea.setMouseOverColor(Configuration.COLOR_TRANSPARENT);
////            mouseOverArea.setNormalColor(Configuration.COLOR_TRANSPARENT);
////        }
////        icon.getMouseOverArea().render(this.getGameContainer(), this.getGraphics());
////        Image image = icon.getImage();
////        if(image != null){
////            image.draw(iconX, iconY);
////        } else{
////            graphics.setColor(Configuration.ICON_BACKGROUND_COLOR);
////            graphics.fillRect(iconX, iconY, iconWidth, iconHeight);
////            graphics.setColor(Configuration.ICON_LABEL_COLOR);
////            graphics.drawString(Label.ADD_ICON_MESSAGE, iconWidth/2 + iconX - (DEFAULT_FIELD_FONT.getWidth(Label.ADD_ICON_MESSAGE)) /2,
////                    iconY + iconHeight / 2);
////        }
//        //return iconHeight;
//        return 0;
//    }
//
////    public Image getBGImage() {
////        try {
////            return new Image(Configuration.BG_REF);
////        } catch (SlickException e) {
////            e.printStackTrace();
////            throw new RuntimeException(e);
////        }
////    }
//
//
//}
