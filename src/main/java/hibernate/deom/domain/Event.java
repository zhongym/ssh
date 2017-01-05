package hibernate.deom.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhong on 2016/6/5.
 */
public class Event {
    private Long id;

    private String title;
    private Date date;

    private Set persons=new HashSet();

    public Event() {}

    public Event(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set getPersons() {
        return persons;
    }

    public void setPersons(Set persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
