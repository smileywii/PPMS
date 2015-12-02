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

import org.springframework.format.annotation.DateTimeFormat;

import ppms.dto.NewUsedSuppDTO;
import ppms.dto.UpdateUsedSuppDTO;

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

  @NotNull
  @Min(1)
  private int dailyDosage;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

  @NotNull
  @OneToOne
  @JoinColumn(name = "supplement_id")
  private NutritionalSupplement supplement;

  @NotNull
  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  protected UsedSupplement() {
  }

  public UsedSupplement(NutritionalSupplement supplementsList, Person person) {
    this.supplement = supplementsList;
    this.person = person;
  }

  public UsedSupplement(NewUsedSuppDTO suppDTO, Person person, NutritionalSupplement supplement) {
    this.dailyDosage = suppDTO.getDailyDosage();
    this.startDate = suppDTO.getStartDate();
    this.endDate = suppDTO.getEndDate();
    this.supplement = supplement;
    this.person = person;
  }

  public void update(UpdateUsedSuppDTO suppDTO) {
    this.dailyDosage = suppDTO.getDailyDosage();
    this.startDate = suppDTO.getStartDate();
    this.endDate = suppDTO.getEndDate();

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
