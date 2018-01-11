package ru.GlobalListener.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.GlobalListener.model.MousePress;

import java.util.Date;

public interface MousePressRepository extends JpaRepository<MousePress, Long>{
    MousePress findByDateAndButtonTitle(Date date, String buttonTitle);
}
