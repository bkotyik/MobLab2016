package bkotyik.mobsoft2016.view;

import java.util.List;

import bkotyik.mobsoft2016.model.Floor;

public interface FloorListView {
    void showFloors(List<Floor> floors);
    void showMessage(String message);
}
