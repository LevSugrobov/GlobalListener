package ru.GlobalListener.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mouse_press")
public class MousePress {
    @Id
    @GeneratedValue
    @Column(name = "mouse_press_id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "mouse_button_title")
    private String buttonTitle;

    @Column(name = "count")
    private Long count;

    public MousePress(){

    }

    public MousePress(Date date, String buttonTitle, Long count) {
        this.date = date;
        this.buttonTitle = buttonTitle;
        this.count = count;
    }

    public void incrementCount(){
        this.count += 1;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }

    public void setButtonTitle(String buttonTitle) {
        this.buttonTitle = buttonTitle;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MousePress{" +
                "id=" + id +
                ", date=" + date +
                ", buttonTitle='" + buttonTitle + '\'' +
                ", count=" + count +
                '}';
    }
}
