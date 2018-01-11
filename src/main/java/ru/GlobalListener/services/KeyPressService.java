package ru.GlobalListener.services;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.GlobalListener.helpers.DateHelper;
import ru.GlobalListener.model.Keypress;
import ru.GlobalListener.repositories.KeypressRepository;
import sun.awt.im.InputMethodManager;

import javax.security.auth.callback.TextInputCallback;
import java.util.Date;

/**
 * Сервис сохранения нажатия клавиш
 */
@Service
public class KeyPressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyPressService.class);

    @Autowired
    private KeypressRepository keypressRepository;

    public void save(NativeKeyEvent nativeKeyEvent) {
        Date currentDate = DateHelper.getCurrentDate();
        Keypress keypress = keypressRepository.findByKeyAndDate(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()), currentDate);
        if (keypress == null) {
            keypress = new Keypress(currentDate, NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()), 1L);
        } else {
            keypress.incrementCount();
        }
        keypressRepository.save(keypress);
    }
}
