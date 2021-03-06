package ru.GlobalListener.listeners;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Listener мыши
 * @author asugrobov
 */
@Configuration
public class MouseListener implements NativeMouseInputListener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MouseListener.class);

    /**
     * Обработка события количества кликов
     * @param nativeMouseEvent - событие
     */
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Clicked: {}", nativeMouseEvent.getClickCount());
    }

    /**
     * Обработка события нажатия кнопки мыши
     * @param nativeMouseEvent - событие
     */
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Pressed: {}", nativeMouseEvent.getButton());
    }

    /**
     * Обработка события отжатия кнопки мыши
     * @param nativeMouseEvent - событие
     */
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Released: {}", nativeMouseEvent.getButton());
    }

    /**
     * Обработка события передвижения мыши
     * @param nativeMouseEvent - событие
     */
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Moved: {}", nativeMouseEvent.getX() + ", " + nativeMouseEvent.getY());
    }

    /**
     * Обработка события выделения мыши
     * @param nativeMouseEvent - событие
     */
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Dragged: {}, {}", nativeMouseEvent.getX(), nativeMouseEvent.getY());
    }
}
