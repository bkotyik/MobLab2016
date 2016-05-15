package bkotyik.mobsoft2016.model.mock;

import java.util.LinkedList;
import java.util.List;

import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.full.FloorDbModel;

public class MockFloorDbModel extends FloorDbModel {
    LinkedList<Floor> values = new LinkedList<>();

    public MockFloorDbModel() {
        values.add(new Floor("F1","Description of F1"));
        values.add(new Floor("F2", "Description of F2"));
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

}
