package bkotyik.mobsoft2016.model.full;

import java.util.List;
import bkotyik.mobsoft2016.model.Floor;

public class FloorDbModel  {
    public List<Floor> fetch() {
        List<Floor> values = Floor.listAll(Floor.class);
        return values;
    }

    public void insert(Floor toInsert) {
        toInsert.save();
    }

    public Floor fetchById(int id) {
        return Floor.findById(Floor.class, id);
    }

    public void removeById(Long id) {
        Floor floor = Floor.findById(Floor.class, id);
        if (floor != null) {
            Floor.delete(floor);
        }
    }

    public void update(Floor floor) {
        Floor f = Floor.findById(Floor.class, floor.getId());
        f.setName(floor.getName());
        f.setDescription(floor.getDescription());
        f.save();
    }
}
