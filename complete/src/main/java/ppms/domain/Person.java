package ppms.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Person implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id")
  private long id;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  @Past
  private Date birthDate;

  @NotNull
  @Size(min = 1, max = 45)
  private String address;

  // @NotNull
  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<Result> results;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<PhysicalDevelopment> physicalDevelopmentList;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<SportDevelopment> sportDevelopmentList;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<TrainingMethod> trainingMethod;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<Membership> memberships;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
  private List<UsedSupplement> usedSupplementsList;

  public Person() {
  }

  public Person(String name, Date date, String address) {
    this.name = name;
    this.birthDate = date;
    this.address = address;
  }

  public Person updatePerson(Person person) {
    this.name = person.name;
    this.birthDate = person.birthDate;
    this.address = person.address;
    this.sport = person.getSport();
    return this;
  }

  @Override
  public String toString() {
    return String.format("People[id=%d, firstName='%s', age='%s', address='%s']", getId(), name, birthDate, address);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getAge() {
    return birthDate;
  }

  public void setAge(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public List<Membership> getMemberships() {
    return memberships;
  }

  public void setMemberships(List<Membership> memberships) {
    this.memberships = memberships;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }

  public List<PhysicalDevelopment> getPhysicalDevelopmentList() {
    return physicalDevelopmentList;
  }

  public void setPhysicalDevelopmentList(List<PhysicalDevelopment> physicalDevelopmentList) {
    this.physicalDevelopmentList = physicalDevelopmentList;
  }

  public List<TrainingMethod> getTrainingMethod() {
    return trainingMethod;
  }

  public void setTrainingMethod(List<TrainingMethod> trainingMethod) {
    this.trainingMethod = trainingMethod;
  }

  public List<SportDevelopment> getSportDevelopmentList() {
    return sportDevelopmentList;
  }

  public void setSportDevelopmentList(List<SportDevelopment> sportDevelopmentList) {
    this.sportDevelopmentList = sportDevelopmentList;
  }

  public List<UsedSupplement> getUsedSupplementsList() {
    return usedSupplementsList;
  }

  public void setUsedSupplementsList(List<UsedSupplement> usedSupplementsList) {
    this.usedSupplementsList = usedSupplementsList;
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public void setId(long id) {
    this.id = id;
  }

  // public MemberList getMembership() {
  // return membership;
  // }
  //
  // public void setMembership(MemberList membership) {
  // this.membership = membership;
  // }

}
