package bkotyik.mobsoft2016.model.mock;

import java.util.LinkedList;
import java.util.List;

import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.full.FloorDbModel;

public class MockFloorDbModel extends FloorDbModel {
    LinkedList<Floor> values = new LinkedList<>();

    public MockFloorDbModel() {
        values.add(new Floor(1, "Floor 1","Description of Floor 1"));
        values.add(new Floor(2, "Floor 2", "Description of Floor 2"));
        values.add(new Floor(2, "Floor 3", "Description of Floor 3"));
    }

    @Override
    public List<Floor> fetch() {
        return values;
    }

    @Override
    public void insert(Floor toInsert) {
        values.add(toInsert);
    }

    public Floor fetchById(int id) {
        return values.get(id);
    }

    public void removeById(Long id) {
        values.remove(id);
    }

    public void update(Floor floor) {
        values.remove(floor.getId());
        values.add(new Integer(floor.getId().toString()),floor);
    }

}
