package ppms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateSportDTO {

  @NotNull
  @Min(1)
  private long sportId;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getSportId() {
    return sportId;
  }

  public void setSportId(long sportId) {
    this.sportId = sportId;
  }

}
