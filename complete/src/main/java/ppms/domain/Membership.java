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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Membership implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "membership_id")
  private long id;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

  @NotNull
  @OneToOne
  @JoinColumn(name = "club_id")
  private Club club;

  @NotNull
  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  public Membership() {
  }

  public Membership(Club club, Person person, Date startDate, Date membeshipEnd) {
    this.club = club;
    this.person = person;
    this.startDate = startDate;
    this.endDate = membeshipEnd;
  }

  @Override
  public String toString() {
    return String.format("MemberList[id=%d, club='%s',people='%s']", id, club);
  }

  public Club getClub() {
    return club;
  }

  public void setClub(Club club) {
    this.club = club;
  }

  // public Person getPerson() {
  // return person;
  // }
  //
  // public void setPerson(Person person) {
  // this.person = person;
  // }

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

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person personList) {
    this.person = personList;
  }

  public long getId() {
    return id;
  }

}
