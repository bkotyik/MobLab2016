package bkotyik.mobsoft2016.presenter;


import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.view.FloorDetailsView;

public class FloorDetailsPresenter extends Presenter<FloorDetailsView> {
    @Inject
    public FloorInteractor floorInteractor;
    @Inject
    public EmployeeInteractor employeeInteractor;

    Floor currentFloor = null;

    public FloorDetailsPresenter() {
        IndoorMapApplication.injector.inject(this);
    }

    public void loadFloor(long _id) {
        try {
            currentFloor = floorInteractor.getFloorFromNetwork(_id);
        } catch (Exception e) {
            currentFloor = floorInteractor.getFloorFromDb(_id);
            view.showMessage(e.getMessage());
        } finally {
            view.showFloorDetails(currentFloor);
        }

        try {
          view.showEmployeeList(employeeInteractor.getEmployeesByFloorIdFromNetwork(_id));
        } catch(Exception e) {
            view.showEmployeeList(employeeInteractor.getEmployeesByFloorIdFromDb(_id));
            view.showMessage(e.getMessage());
        }

    }
    public void deleteFloor() {
        try {
            floorInteractor.removeFloorFromNetwork(currentFloor.getId());
        } catch (Exception e) {
            floorInteractor.removeFloorFromDb(currentFloor.getId());
            view.showMessage(e.getMessage());
        } finally {
            view.showFloorDetails(currentFloor);
        }
    }
}
