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
public class TrainingMethod implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "training_id")
  private long id;

  private Date startDate;
  private Date endDate;
  private String name;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  protected TrainingMethod() {
  }

  public TrainingMethod(String name, Sport sport, Person person) {
    this.name = name;
    this.sport = sport;
    this.person = person;
  }

  @Override
  public String toString() {
    return String.format("TrainingName[id=%d, name='%s', person='%s', sport='%s']", id, name, person, sport);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public long getId() {
    return id;
  }

}
