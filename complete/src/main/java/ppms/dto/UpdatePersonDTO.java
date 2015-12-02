package ppms.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdatePersonDTO {

  @NotNull
  @Min(1)
  private Long personId;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @Past
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;

  @NotNull
  @Size(min = 1, max = 45)
  private String address;

  @NotNull
  @Min(1)
  private Long sportId;

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getSportId() {
    return sportId;
  }

  public void setSportId(Long sportId) {
    this.sportId = sportId;
  }

}
