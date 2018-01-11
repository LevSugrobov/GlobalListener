package listeners;

import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class MouseWheelListener implements NativeMouseWheelListener {
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent) {
        System.out.println("Mouse Wheel Moved: " + nativeMouseWheelEvent.getWheelRotation());
    }
}
