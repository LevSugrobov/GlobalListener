package ru.GlobalListener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.GlobalListener.model.Keypress;

public interface KeypressRepository extends JpaRepository<Keypress, Long> {
}
