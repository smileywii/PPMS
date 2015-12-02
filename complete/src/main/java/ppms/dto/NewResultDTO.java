package ppms.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewResultDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6379073547798078059L;

  @NotNull
  @Min(1)
  private int position;

  @NotNull
  private Long eventId;

  @NotNull
  private Long personId;

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public NewResultDTO() {
  }

}
