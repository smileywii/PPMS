package ppms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateEventDTO extends NewEventDTO {

  @NotNull
  @Min(1)
  private long eventId;

  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }

}
