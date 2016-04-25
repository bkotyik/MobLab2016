package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.FloorModel;

public class FloorInteractor {
    @Inject
    FloorInteractor model;
    private List<FloorModel> floors;

    public FloorInteractor() {
        IndoorMapApplication.injector.inject(this);
        this.floors = new ArrayList<FloorModel>();
    }

    public List<FloorModel> getFloors() {
        return floors;
    }

    public FloorModel getFloor(int i) {
        return this.floors.get(i);
    }

}