package listeners;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.List;

public class KeyboardListener implements NativeKeyListener {

    List<Integer> pressedKeys = new ArrayList<Integer>();

    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        pressedKeys.add(nativeKeyEvent.getKeyCode());
        if((pressedKeys.contains(NativeKeyEvent.VC_CONTROL_L) || pressedKeys.contains(NativeKeyEvent.VC_CONTROL_R)) &&
                pressedKeys.contains(NativeKeyEvent.VC_C)){
            try {
                System.out.println("Ctrl + C detected. Exiting...");
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        Integer currentKeyCode = nativeKeyEvent.getKeyCode();
        if(pressedKeys.contains(currentKeyCode)){
            pressedKeys.remove(currentKeyCode);
        }
    }

    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }
}
