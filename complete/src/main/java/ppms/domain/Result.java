package ppms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Result implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "result_id")
  private long id;

  @NotNull
  @Min(1)
  private int position;

  @OneToOne
  @JoinColumn(name = "event_id")
  private Event event;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  public Result() {
  }

  public Result(int position, Event event, Person person, Sport sport) {
    this.setPosition(position);
    this.event = event;
    this.person = person;
    this.sport = sport;

  }

  @Override
  public String toString() {
    return String.format("Results[id=%d, position='%s', event='%s', person='%s', sport='%s']", id, getPosition(),
        event, person, sport);
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
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

  public long getId() {
    return id;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

}
