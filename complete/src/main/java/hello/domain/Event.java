package hello.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "event_id")
  private long id;

  @NotNull
  @Size(min = 1, max = 45)
  private String city;

  @NotNull
  @Size(min = 1, max = 45)
  private String stadium;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private Date date;

  protected Event() {
  }

  public Event(String city, String stadium, String name) {
    this.city = city;
    this.stadium = stadium;
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Event[id=%d, city='%s', stadium='%s', name='%s']", id, city, stadium, name);
  }

  public long getId() {
    return id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStadium() {
    return stadium;
  }

  public void setStadium(String stadium) {
    this.stadium = stadium;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
