package hello.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class DateHolder {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private Date startDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @NotNull
  private Date endDate;

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

}
