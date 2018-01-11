package ru.GlobalListener.helpers;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Хэлпер для хранения нажатых клавиш
 * @author asugrobov
 */
@Configuration
public class PressedKeysHelper {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PressedKeysHelper.class);

    /**
     * Список нажатых клавиш
     */
    List<Integer> pressedKeys;

    /**
     * Конструктор по умолчанию
     */
    public PressedKeysHelper(){
        pressedKeys = new ArrayList<Integer>();
    }

    /**
     * Добавление кода нажатой клавиши
     * @param pressedKey - код
     */
    public void addPressedKey(Integer pressedKey){
        LOGGER.info("adding key with code {} into pressedKeys list", pressedKey);
        pressedKeys.add(pressedKey);
    }

    /**
     * Удаление кода нажатой клавиши
     * @param key - код
     */
    public void removeKey(Integer key){
        if(pressedKeys.contains(key)){
            LOGGER.info("Removing key with code {} from pressedKeys list", key);
            pressedKeys.remove(key);
        }
    }

    /**
     * Проверка нажатия клавиш для завершения приложения
     * @return true, если нажаты
     */
    public boolean haveExitCombination(){
        return (pressedKeys.contains(NativeKeyEvent.VC_CONTROL_L) || pressedKeys.contains(NativeKeyEvent.VC_CONTROL_R)) &&
                pressedKeys.contains(NativeKeyEvent.VC_C);
    }
}
