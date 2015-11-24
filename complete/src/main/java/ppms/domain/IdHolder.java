package ppms.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class IdHolder implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @NotNull
  private long id;

  private long secondaryId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public IdHolder() {
  }

  public long getSecondaryId() {
    return secondaryId;
  }

  public void setSecondaryId(long id) {
    this.secondaryId = id;
  }

}
