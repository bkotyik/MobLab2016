package bkotyik.mobsoft2016.model;

import com.orm.dsl.Table;

@Table
public class EmployeeModel {

    private Long id;
    private String name;
    private String roomNumber;
    private int floorId;

    public EmployeeModel() {

    }

    public String getName() {
        return this.name;
    }
}
