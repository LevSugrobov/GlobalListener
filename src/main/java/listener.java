import listeners.KeyboardListener;
import listeners.MouseListener;
import listeners.MouseWheelListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class listener {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex){
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        registerListeners();
    }

    private static void registerListeners() {
        MouseListener mouseListener = new MouseListener();
        KeyboardListener keyboardListener = new KeyboardListener();
        MouseWheelListener mouseWheelListener = new MouseWheelListener();
        GlobalScreen.addNativeKeyListener(keyboardListener);
        GlobalScreen.addNativeMouseListener(mouseListener);
        GlobalScreen.addNativeMouseMotionListener(mouseListener);
        GlobalScreen.addNativeMouseWheelListener(mouseWheelListener);
    }

}
