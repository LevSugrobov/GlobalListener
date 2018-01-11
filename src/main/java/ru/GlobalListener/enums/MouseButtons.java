package ru.GlobalListener.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление, описывающие кнопки мыши
 * @author asugrobov
 */
public enum MouseButtons {
    LEFT(1, "Левая кнопка"),
    WHEEL(2, "Колесо"),
    RIGHT(3, "Правая кнопка");

    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        for(MouseButtons mouseButtons:MouseButtons.values()){
            map.put(mouseButtons.buttonNumber, mouseButtons.buttonTitle);
        }
    }

    public static String getButtonTitle(Integer buttonNumber){
        return map.get(buttonNumber);
    }

    private Integer buttonNumber;
    private String buttonTitle;

    MouseButtons(Integer buttonNumber, String buttonTitle){
        this.buttonNumber = buttonNumber;
        this.buttonTitle = buttonTitle;
    }

    public Integer getButtonNumber() {
        return buttonNumber;
    }

    public void setButtonNumber(Integer buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }
}
