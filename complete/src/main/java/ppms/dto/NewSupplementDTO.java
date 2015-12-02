package ppms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewSupplementDTO {

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

}
