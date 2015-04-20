package main.java.gurps.graphics.components;

/**
 * Created by Caio on 17/04/2015.
 */
public abstract class BaseTextField {

    //private TextArea textArea;
    //private TextField textField;
    private int keyCounter = 0;
    private int triggerCounter = 0;
    private String initialValue;
    private String fieldName;

    public BaseTextField(String fieldName, String initialValue) {
        this.initialValue = initialValue;
        this.fieldName = fieldName;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void react() {
//        TextField textField = this.getTextField();
//        if(Keyboard.isKeyDown(Keyboard.KEY_BACK) && textField.hasFocus()){
//            int triggerCounter = this.getTriggerCounter();
//            if(triggerCounter > Configuration.TRIGGER_COUNTER_THRESHOLD){
//                int keyCounter = this.getKeyCounter();
//                if(keyCounter <= 0){
//                    this.setKeyCounter(Configuration.KEY_COUNTER_DEFAULT);
//                    String text = textField.getText();
//                    int length = text.length();
//                    if(length > 0) {
//                        textField.setText(text.substring(0,
//                                length - 1));
//                    }
//                } else{
//                    this.setKeyCounter(keyCounter - 1);
//                }
//            } else{
//                this.setTriggerCounter(triggerCounter +1);
//            }
//        } else{
//            this.setTriggerCounter(0);
//        }
    }

//    public TextField getTextField() {
//        return textField;
//    }
//
//    public void setTextField(TextField textField) {
//        this.textField = textField;
//    }

    public int getKeyCounter() {
        return keyCounter;
    }

    public void setKeyCounter(int keyCounter) {
        this.keyCounter = keyCounter;
    }

    public int getTriggerCounter() {
        return triggerCounter;
    }

    public void setTriggerCounter(int triggerCounter) {
        this.triggerCounter = triggerCounter;
    }
}
