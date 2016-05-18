package bkotyik.mobsoft2016.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table
public class Floor extends SugarRecord {

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    public Floor(String _name) {
        this.name = _name;
    }

    public Floor(String _name, String _description) {
        this.name = _name;
        this.description = _description;
    }

    public Floor(long _id, String _name, String _description) {
        this.setId(_id);
        this.name = _name;
        this.description = _description;
    }

    public Floor() {

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
        return Objects.equals(this.getId(), floor.getId()) &&
                Objects.equals(name, floor.name) &&
                Objects.equals(description, floor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Floor {\n");

        sb.append("    id: ").append(toIndentedString(this.getId())).append("\n");
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
