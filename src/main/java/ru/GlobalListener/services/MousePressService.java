package ru.GlobalListener.services;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.GlobalListener.enums.MouseButtons;
import ru.GlobalListener.helpers.DateHelper;
import ru.GlobalListener.model.MousePress;
import ru.GlobalListener.repositories.MousePressRepository;

import java.util.Date;

@Service
public class MousePressService implements IEventService {
    @Autowired
    private MousePressRepository mousePressRepository;

    @Override
    public void save(NativeInputEvent event) {
        if(event instanceof NativeMouseEvent) {
            NativeMouseEvent nativeMouseEvent = (NativeMouseEvent) event;
            Date currentDate = DateHelper.getCurrentDate();
            String buttonTitle = MouseButtons.getButtonTitle(nativeMouseEvent.getButton());
            MousePress mousePress = mousePressRepository.findByDateAndButtonTitle(currentDate, buttonTitle);
            if (mousePress == null) {
                mousePress = new MousePress(currentDate, buttonTitle, 1L);
            } else {
                mousePress.incrementCount();
            }
            mousePressRepository.save(mousePress);
        }
    }
}
