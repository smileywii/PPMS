package hello.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class MemberList implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "memberlist_id")
  private long id;

  private Date startDate;
  private Date endDate;

  @OneToOne
  @JoinColumn(name = "club_id")
  private Club club;

  @ManyToMany(targetEntity = hello.domain.Person.class, mappedBy = "memberships")
  private List<Person> personList;

  protected MemberList() {
  }

  public MemberList(Club club, Person personList, Date startDate, Date membeshipEnd) {
    this.club = club;
    // this.person = personList;
    this.setStartDate(startDate);
    this.setEndDate(membeshipEnd);
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

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }

  public long getId() {
    return id;
  }

}
