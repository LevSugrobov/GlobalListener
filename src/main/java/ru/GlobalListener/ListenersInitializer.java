package ru.GlobalListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.GlobalListener.listeners.KeyboardListener;
import ru.GlobalListener.listeners.MouseListener;
import ru.GlobalListener.listeners.MouseWheelListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.GlobalListener.model.Keypress;
import ru.GlobalListener.repositories.KeypressRepository;

import java.util.List;

/**
 * Класс инициализации листенеров
 * @author asugrobov
 */
@Component
public class ListenersInitializer {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ListenersInitializer.class);
    @Autowired
    private MouseListener mouseListener;
    @Autowired
    private KeyboardListener keyboardListener;
    @Autowired
    private MouseWheelListener mouseWheelListener;
    @Autowired
    private KeypressRepository keypressRepository;

    public void initListeners() {
        disableDefaultLogger();
        List<Keypress> keypresses = keypressRepository.findAll();
        LOGGER.info("keypresses found {}", keypresses.size());
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex){
            LOGGER.error("There was a problem registering the native hook.");
            LOGGER.error(ex.getMessage());
            System.exit(1);
        }
        registerListeners();
    }

    /**
     * Регистрация листенеров
     */
    private void registerListeners() {
        LOGGER.info("registering listeners...");
        GlobalScreen.addNativeKeyListener(keyboardListener);
        GlobalScreen.addNativeMouseListener(mouseListener);
        GlobalScreen.addNativeMouseMotionListener(mouseListener);
        GlobalScreen.addNativeMouseWheelListener(mouseWheelListener);
        LOGGER.info("listener registered");
    }

    /**
     * Отключение логирования в библиотеке JNativeHook
     */
    private static void disableDefaultLogger(){
        java.util.logging.LogManager.getLogManager().reset();
    }

}
