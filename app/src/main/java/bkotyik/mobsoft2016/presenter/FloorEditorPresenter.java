package bkotyik.mobsoft2016.presenter;

import javax.inject.Inject;

import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.view.FloorEditorView;

public class FloorEditorPresenter extends Presenter<FloorEditorView> {
    @Inject
    public FloorInteractor floorInteractor;
    @Inject
    public EmployeeInteractor employeeInteractor;

    public FloorEditorPresenter() {

    }

    public void addEmployee(String name, String roomNumber) {
    }

    public void addFloor(String name, String description) {}

    public void saveFloorChanges(Floor floor) {}

    public void loadFloor(int id) {}

    public void removeEmployee(int id) {}
}
