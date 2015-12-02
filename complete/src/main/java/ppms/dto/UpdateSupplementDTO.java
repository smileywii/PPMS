package ppms.dto;

public class UpdateSupplementDTO extends NewSupplementDTO {

  private long supplementId;

  public long getSupplementId() {
    return supplementId;
  }

  public void setSupplementId(long supplementId) {
    this.supplementId = supplementId;
  }
}
