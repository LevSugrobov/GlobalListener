package ru.GlobalListener.listeners;

import ru.GlobalListener.enums.WheelEnum;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Listener колеса мыши
 * @author asugrobov
 */
public class MouseWheelListener implements NativeMouseWheelListener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MouseWheelListener.class);

    /**
     * Обработчик колеса мыши
     * @param nativeMouseWheelEvent - событие
     */
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent) {
        LOGGER.info("Mouse Wheel Moved: {}", WheelEnum.getDirectionTitle(nativeMouseWheelEvent.getWheelRotation()));
    }
}
