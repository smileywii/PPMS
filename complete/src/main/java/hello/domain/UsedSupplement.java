package hello.domain;

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
public class UsedSupplement implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "usedsupplement_id")
  private long id;

  private int dailyDosage;
  private Date startDate;
  private Date endDate;

  @OneToOne
  @JoinColumn(name = "supplement_id")
  private NutritionalSupplement supplement;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  protected UsedSupplement() {
  }

  public UsedSupplement(NutritionalSupplement supplementsList, Person person) {
    this.supplement = supplementsList;
    this.person = person;
  }

  @Override
  public String toString() {
    return String.format("usedSupplements[id=%d, supplements='%s', person='%s']", id, supplement, person);
  }

  public NutritionalSupplement getSupplement() {
    return supplement;
  }

  public void setSupplement(NutritionalSupplement supplement) {
    this.supplement = supplement;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public int getDailyDosage() {
    return dailyDosage;
  }

  public void setDailyDosage(int dailyDosage) {
    this.dailyDosage = dailyDosage;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public long getId() {
    return id;
  }

}
