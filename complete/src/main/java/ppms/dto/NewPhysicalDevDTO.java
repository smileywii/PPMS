package ppms.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class NewPhysicalDevDTO {

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
  @Min(1)
  private Long personId;

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

  public int getBodyFat() {
    return bodyFat;
  }

  public void setBodyFat(int bodyFat) {
    this.bodyFat = bodyFat;
  }

  public int getBloodPressure() {
    return bloodPressure;
  }

  public void setBloodPressure(int bloodPressure) {
    this.bloodPressure = bloodPressure;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

}
