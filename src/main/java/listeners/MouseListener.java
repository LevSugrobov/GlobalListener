package listeners;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Mouse Clicked: " + nativeMouseEvent.getClickCount());
    }

    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Mouse Pressed: " + nativeMouseEvent.getButton());
    }

    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Mouse Released: " + nativeMouseEvent.getButton());
    }

    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Mouse Moved: " + nativeMouseEvent.getX() + ", " + nativeMouseEvent.getY());
    }

    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
        System.out.println("Mouse Dragged: " + nativeMouseEvent.getX() + ", " + nativeMouseEvent.getY());
    }
}
