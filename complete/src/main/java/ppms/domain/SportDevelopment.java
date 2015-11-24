package ppms.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SportDevelopment implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "sportdev_id")
  private long id;

  private Date date;
  private Time time;
  private int distance;
  private int weight;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  protected SportDevelopment() {
  }

  public SportDevelopment(Date month, Time time, int distance, Person person, Sport sport, int weight) {
    this.date = month;
    this.time = time;
    this.distance = distance;
    this.person = person;
    this.sport = sport;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return String.format("PhysicalDevelopment[id=%d, month='%s', time='%s', distance='%s', person='%s', sport='%s']",
        id, date, time, distance, person, sport);
  }

  public Date getMonth() {
    return date;
  }

  public void setMonth(Date month) {
    this.date = month;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getId() {
    return id;
  }

}
