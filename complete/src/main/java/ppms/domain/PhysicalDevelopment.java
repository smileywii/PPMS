package ppms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PhysicalDevelopment implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "physicaldev_id")
  private long id;

  private Date date;
  private int weight;
  private int height;
  private int bodyFat;
  private int bloodPressure;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  protected PhysicalDevelopment() {
  }

  public PhysicalDevelopment(Date date, int weight, int height, int bodyFat, int bloodPressure, Person person,
      Sport sport) {
    this.date = date;
    this.weight = weight;
    this.height = height;
    this.bodyFat = bodyFat;
    this.bloodPressure = bloodPressure;
    this.person = person;
    this.sport = sport;

  }

  @Override
  public String toString() {
    return String
        .format(
            "PhysicalDevelopment[id=%d, date='%s', weight='%s', height='%s', bodyFat='%s', bloodPressure='%s', person='%s', sport='%s']",
            id, date, weight, height, bodyFat, bloodPressure, person, sport);
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getBodyFAt() {
    return bodyFat;
  }

  public void setBodyFAt(int bodyFAt) {
    this.bodyFat = bodyFAt;
  }

  public int getBloodPressure() {
    return bloodPressure;
  }

  public void setBloodPressure(int bloodPressure) {
    this.bloodPressure = bloodPressure;
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

  public int getBodyFat() {
    return bodyFat;
  }

  public void setBodyFat(int bodyFat) {
    this.bodyFat = bodyFat;
  }

  public long getId() {
    return id;
  }

}
