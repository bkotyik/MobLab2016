package bkotyik.mobsoft2016.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Employee extends SugarRecord {

    @SerializedName("name")
    private String name = null;

    @SerializedName("roomNumber")
    private String roomNumber = null;

    @SerializedName("floorId")
    private Integer floorId = null;

    public Employee(String _name) {
        this.name = _name;
    }

    public Employee(String _name, String _roomNumber) {
        this.name = _name;
        this.roomNumber = _roomNumber;
    }

    public Employee(String _name, String _roomNumber, int _floorId) {
        this.name = _name;
        this.roomNumber = _roomNumber;
        this.floorId = _floorId;
    }

    public Employee() {

    }


    /**
     * A munkatars teljes neve
     **/
    @ApiModelProperty(required = true, value = "A munkatars teljes neve")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     * munkatars szobaszama. Nem feltetlen szam, tartalmazhat nem numerikus karaktereket is. pl. 206c szoba
     **/
    @ApiModelProperty(value = "munkatars szobaszama. Nem feltetlen szam, tartalmazhat nem numerikus karaktereket is. pl. 206c szoba")
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     * A munkatars szob?ja melyik emeleten van.
     **/
    @ApiModelProperty(required = true, value = "A munkatars szobaja melyik emeleten van.")
    public Integer getFloorId() {
        return floorId;
    }
    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(this.getId(), employee.getId()) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(roomNumber, employee.roomNumber) &&
                Objects.equals(floorId, employee.floorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name, roomNumber, floorId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Employee {\n");

        sb.append("    id: ").append(toIndentedString(this.getId())).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    roomNumber: ").append(toIndentedString(roomNumber)).append("\n");
        sb.append("    floorId: ").append(toIndentedString(floorId)).append("\n");
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