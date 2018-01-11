import listeners.KeyboardListener;
import listeners.MouseListener;
import listeners.MouseWheelListener;
import org.apache.log4j.LogManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Главный класс
 * @author asugrobov
 */
public class listener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(listener.class);

    public static void main(String[] args) {
        disableDefaultLogger();
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
    private static void registerListeners() {
        LOGGER.info("registering listeners...");
        MouseListener mouseListener = new MouseListener();
        KeyboardListener keyboardListener = new KeyboardListener();
        MouseWheelListener mouseWheelListener = new MouseWheelListener();
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
