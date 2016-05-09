package bkotyik.mobsoft2016.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table
@ApiModel(description = "")
public class Floor   {

    @SerializedName("id")
    private Integer id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;



    /**
     * Az emelet egyedi azonositoja
     **/
    @ApiModelProperty(required = true, value = "Az emelet egyedi azonositoja")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Az emelet neve, pl. Q epulet elso szintje
     **/
    @ApiModelProperty(required = true, value = "Az emelet neve, pl. Q epulet elso szintje")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Az emelet leirasa. pl. mely tanszekek kaptak helyet az emeleten
     **/
    @ApiModelProperty(value = "Az emelet leirasa. pl. mely tanszekek kaptak helyet az emeleten")
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
        Floor floor = (Floor) o;
        return Objects.equals(id, floor.id) &&
                Objects.equals(name, floor.name) &&
                Objects.equals(description, floor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Floor {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
