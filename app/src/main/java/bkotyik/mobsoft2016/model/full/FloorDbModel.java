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
}
