package ppms.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class NewUsedSuppDTO {

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
  @Min(1)
  private long supplementId;

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

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public long getSupplementId() {
    return supplementId;
  }

  public void setSupplementId(long supplementId) {
    this.supplementId = supplementId;
  }

}
