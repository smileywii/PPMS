package ppms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewSportDTO {

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
