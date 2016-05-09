package bkotyik.mobsoft2016.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class NewFloor   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("description")
  private String description = null;
  

  
  /**
   * Az emelet neve, pl. Q �p�let els� szintje
   **/
  @ApiModelProperty(required = true, value = "Az emelet neve, pl. Q �p�let els� szintje")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Az emelet le�r�sa. pl. mely tansz�kek kaptak helyet az emeleten
   **/
  @ApiModelProperty(value = "Az emelet le�r�sa. pl. mely tansz�kek kaptak helyet az emeleten")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewFloor newFloor = (NewFloor) o;
    return Objects.equals(name, newFloor.name) &&
        Objects.equals(description, newFloor.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewFloor {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
