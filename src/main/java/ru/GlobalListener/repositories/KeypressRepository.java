package ru.GlobalListener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.GlobalListener.model.Keypress;

import java.util.Date;

public interface KeypressRepository extends JpaRepository<Keypress, Long> {
    Keypress findByKeyAndDate(String key, Date date);
}
