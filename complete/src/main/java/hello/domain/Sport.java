package hello.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Sport implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "sport_id")
  private long id;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  protected Sport() {
  }

  public Sport(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Results[id=%d, name='%s']", id, name);
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

}
