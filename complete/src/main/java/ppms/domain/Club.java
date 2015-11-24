package ppms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Club implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "club_id")
  private long id;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @NotNull
  @Size(min = 1, max = 45)
  private String headquarter;

  @OneToOne
  @JoinColumn(name = "sport_id")
  private Sport sport;

  public Club() {
  }

  public Club(String name, String headquarter) {
    this.name = name;
    this.headquarter = headquarter;
  }

  @Override
  public String toString() {
    return String.format("Club[id=%d, name='%s', hq='%s']", id, name, headquarter);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getHeadquarter() {
    return headquarter;
  }

  public void setHeadquarter(String headquarter) {
    this.headquarter = headquarter;
  }

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

}
