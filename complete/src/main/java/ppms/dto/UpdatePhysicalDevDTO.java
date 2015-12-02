package ppms.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdatePhysicalDevDTO {

  @NotNull
  @Min(1)
  private Long developmentId;

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

  public Long getDevelopmentId() {
    return developmentId;
  }

  public void setDevelopmentId(Long developmentId) {
    this.developmentId = developmentId;
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

}
