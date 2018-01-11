package ru.GlobalListener.listeners;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.GlobalListener.enums.MouseButtons;
import ru.GlobalListener.services.MousePressService;

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

    @Autowired
    private MousePressService mousePressService;

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
        LOGGER.info("Mouse Pressed: {}", MouseButtons.getButtonTitle(nativeMouseEvent.getButton()));
        mousePressService.save(nativeMouseEvent);
    }

    /**
     * Обработка события отжатия кнопки мыши
     * @param nativeMouseEvent - событие
     */
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        LOGGER.info("Mouse Released: {}", MouseButtons.getButtonTitle(nativeMouseEvent.getButton()));
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
