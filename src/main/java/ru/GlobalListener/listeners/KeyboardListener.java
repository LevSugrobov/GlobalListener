package ru.GlobalListener.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.GlobalListener.helpers.PressedKeysHelper;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.GlobalListener.model.Keypress;
import ru.GlobalListener.repositories.KeypressRepository;

import java.util.Date;

/**
 * Listener клавиатуры
 * @author asugrobov
 */
@Configuration
public class KeyboardListener implements NativeKeyListener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(KeyboardListener.class);
    @Autowired
    PressedKeysHelper pressedKeysHelper;
    @Autowired
    private KeypressRepository keypressRepository;

    /**
     * Конструктор по умолчанию
     */

    /**
     * Обработка события нажатия клавиши
     * @param nativeKeyEvent - событие
     */
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        LOGGER.info("Key Pressed: {}", NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        pressedKeysHelper.addPressedKey(nativeKeyEvent.getKeyCode());
        Keypress keypress = new Keypress(new Date(), NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()), 1L);
        keypressRepository.save(keypress);
        LOGGER.info("{}", keypressRepository.count());
        if(pressedKeysHelper.haveExitCombination()){
            try {
                LOGGER.info("Ctrl + C detected. Exiting...");
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Обработка события отжатия клавиши
     * @param nativeKeyEvent - событие
     */
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        LOGGER.info("Key Released: {}", NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        pressedKeysHelper.removeKey(nativeKeyEvent.getKeyCode());
    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        LOGGER.info("Key Typed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }
}
