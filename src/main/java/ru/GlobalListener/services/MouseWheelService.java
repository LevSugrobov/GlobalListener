package ru.GlobalListener.services;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.GlobalListener.enums.WheelEnum;
import ru.GlobalListener.helpers.DateHelper;
import ru.GlobalListener.model.MouseWheel;
import ru.GlobalListener.repositories.MouseWheelRepository;

import java.util.Date;

@Service
public class MouseWheelService implements IEventService{

    @Autowired
    private MouseWheelRepository mouseWheelRepository;

    @Override
    public void save(NativeInputEvent event) {
        if(event instanceof NativeMouseWheelEvent){
            NativeMouseWheelEvent nativeMouseWheelEvent = (NativeMouseWheelEvent) event;
            Date currentDate = DateHelper.getCurrentDate();
            String direction = WheelEnum.getDirectionTitle(nativeMouseWheelEvent.getWheelRotation());
            MouseWheel mouseWheel = mouseWheelRepository.findByDateAndDirection(currentDate, direction);
            if(mouseWheel == null){
                mouseWheel = new MouseWheel(currentDate, direction, 1L);
            } else {
                mouseWheel.incrementCount();
            }
            mouseWheelRepository.save(mouseWheel);
        }
    }
}
