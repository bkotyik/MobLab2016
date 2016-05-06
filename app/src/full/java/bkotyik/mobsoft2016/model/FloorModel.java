package bkotyik.mobsoft2016.model;

import com.orm.dsl.Table;

@Table
public class FloorModel {

    private Long id;
    private String name;
    private String description;

    public FloorModel() {

    }

    public String getName() {
        return this.name;
    }
}
