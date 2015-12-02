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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import ppms.dto.NewPhysicalDevDTO;
import ppms.dto.UpdatePhysicalDevDTO;

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

  @Past
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  @NotNull
  @Min(1)
  private int weight;

  @NotNull
  @Min(1)
  private int height;

  @NotNull
  @Min(1)
  private int bodyFat;

  @NotNull
  @Min(1)
  private int bloodPressure;

  @NotNull
  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @NotNull
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

  public PhysicalDevelopment(NewPhysicalDevDTO devDTO, Person person) {
    this.date = devDTO.getDate();
    this.weight = devDTO.getWeight();
    this.height = devDTO.getHeight();
    this.bodyFat = devDTO.getBodyFat();
    this.bloodPressure = devDTO.getBloodPressure();
    this.person = person;
    this.sport = person.getSport();
  }

  public void update(UpdatePhysicalDevDTO devDTO) {
    this.date = devDTO.getDate();
    this.weight = devDTO.getWeight();
    this.height = devDTO.getHeight();
    this.bodyFat = devDTO.getBodyFat();
    this.bloodPressure = devDTO.getBloodPressure();
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
