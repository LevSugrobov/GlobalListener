package ru.GlobalListener.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mouse_wheel")
public class MouseWheel implements IEventEntity {
    @Id
    @GeneratedValue
    @Column(name = "mouse_wheel_id")
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name = "direction")
    private String direction;

    @Column(name = "count")
    private Long count;

    public MouseWheel(){

    }

    public MouseWheel(Date date, String direction, Long count) {
        this.date = date;
        this.direction = direction;
        this.count = count;
    }

    @Override
    public void incrementCount() {
        this.count++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MouseWheel{" +
                "id=" + id +
                ", date=" + date +
                ", direction='" + direction + '\'' +
                ", count=" + count +
                '}';
    }
}
