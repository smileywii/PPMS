package ppms.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NutritionalSupplement implements Serializable {

  /**
     * 
     */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "supplement_id")
  private long id;

  @NotNull
  @Size(min = 1, max = 45)
  private String name;

  @NotNull
  @Size(min = 1, max = 45)
  private String brand;

  @NotNull
  @Min(1)
  private int quantity;

  @NotNull
  @Size(min = 1, max = 45)
  private String unit;

  @NotNull
  @Min(1)
  private int price;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "supplement")
  private List<UsedSupplement> supplementList;

  protected NutritionalSupplement() {
  }

  public NutritionalSupplement(String name, String brand, int quantity, String unit, int price) {
    this.name = name;
    this.brand = brand;
    this.quantity = quantity;
    this.unit = unit;
    this.price = price;

  }

  @Override
  public String toString() {
    return String.format("NutritionalSupplement[id=%d, name='%s', brand='%s', quantity='%s', unit='%s', price='%s']",
        id, name, brand, quantity, unit, price);
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getUnit() {
    return unit;
  }

  public long getId() {
    return id;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public List<UsedSupplement> getSupplementList() {
    return supplementList;
  }

  public void setSupplementList(List<UsedSupplement> supplementList) {
    this.supplementList = supplementList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
