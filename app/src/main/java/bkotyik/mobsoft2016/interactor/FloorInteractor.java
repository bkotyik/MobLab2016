package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.full.FloorDbModel;
import bkotyik.mobsoft2016.network.FloorsApi;

public class FloorInteractor {
    @Inject
    FloorDbModel model;
    @Inject
    FloorsApi api;

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