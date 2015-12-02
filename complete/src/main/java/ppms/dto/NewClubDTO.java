package ppms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewClubDTO {

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @NotNull
  @Size(min = 1, max = 45)
  private String headquarter;

  @Min(1)
  @NotNull
  private long sportId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHeadquarter() {
    return headquarter;
  }

  public void setHeadquarter(String headquarter) {
    this.headquarter = headquarter;
  }

  public long getSportId() {
    return sportId;
  }

  public void setSportId(long sportId) {
    this.sportId = sportId;
  }

}
