package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Floor;

public class FloorInteractor {
    @Inject
    FloorInteractor model;
    private List<Floor> floors;

    public FloorInteractor() {
        IndoorMapApplication.injector.inject(this);
        this.floors = new ArrayList<Floor>();
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Floor getFloor(int i) {
        return this.floors.get(i);
    }

}