package ru.GlobalListener.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ru.GlobalListener.enums.WheelEnum;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.GlobalListener.services.MouseWheelService;

/**
 * Listener колеса мыши
 * @author asugrobov
 */
@Configuration
public class MouseWheelListener implements NativeMouseWheelListener {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MouseWheelListener.class);

    @Autowired
    private MouseWheelService mouseWheelService;

    /**
     * Обработчик колеса мыши
     * @param nativeMouseWheelEvent - событие
     */
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent) {
        LOGGER.info("Mouse Wheel Moved: {}", WheelEnum.getDirectionTitle(nativeMouseWheelEvent.getWheelRotation()));
        mouseWheelService.save(nativeMouseWheelEvent);
    }
}
