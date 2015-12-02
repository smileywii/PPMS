package ppms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateResultDTO {

  @Min(1)
  @NotNull
  private Long resultId;

  @Min(1)
  @NotNull
  private int position;

  public Long getResultId() {
    return resultId;
  }

  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

}
