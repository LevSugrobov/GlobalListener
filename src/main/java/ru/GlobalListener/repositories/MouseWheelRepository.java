package ru.GlobalListener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.GlobalListener.model.MouseWheel;

import java.util.Date;

public interface MouseWheelRepository extends JpaRepository<MouseWheel, Long> {
    MouseWheel findByDateAndDirection(Date date, String direction);
}
