package ru.GlobalListener.helpers;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.GlobalListener.services.KeyPressService;

import java.util.ArrayList;
import java.util.List;

/**
 * Хэлпер для хранения нажатых клавиш
 *
 * @author asugrobov
 */
@Component
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
    public PressedKeysHelper() {
        pressedKeys = new ArrayList<Integer>();
    }

    /**
     * Добавление кода нажатой клавиши
     *
     * @param keyCode - код
     */
    public void addPressedKey(Integer keyCode) {
        LOGGER.info("adding key with code {} into pressedKeys list", keyCode);
        pressedKeys.add(keyCode);
    }

    /**
     * Удаление кода нажатой клавиши
     *
     * @param key - код
     */
    public void removeKey(Integer key) {
        if (pressedKeys.contains(key)) {
            LOGGER.info("Removing key with code {} from pressedKeys list", key);
            pressedKeys.remove(key);
        }
    }

    /**
     * Проверка нажатия клавиш для завершения приложения
     *
     * @return true, если нажаты
     */
    public boolean haveExitCombination() {
        return (pressedKeys.contains(NativeKeyEvent.VC_CONTROL_L) || pressedKeys.contains(NativeKeyEvent.VC_CONTROL_R)) &&
                (pressedKeys.contains(NativeKeyEvent.VC_ALT_L) || pressedKeys.contains(NativeKeyEvent.VC_ALT_R)) &&
                (pressedKeys.contains(NativeKeyEvent.VC_SHIFT_L) || pressedKeys.contains(NativeKeyEvent.VC_SHIFT_R)) &&
                pressedKeys.contains(NativeKeyEvent.VC_C);
    }
}
