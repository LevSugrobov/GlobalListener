package ru.GlobalListener.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="key_press")
public class Keypress {
    @Id
    @GeneratedValue
    @Column(name = "key_press_id")
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "key")
    private String key;
    @Column(name = "count")
    private Long count;

    public Keypress(){

    }

    public Keypress(Date date, String key, Long count) {
        this.date = date;
        this.key = key;
        this.count = count;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Keypress{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", key='" + key + '\'' +
                ", count=" + count +
                '}';
    }
}
