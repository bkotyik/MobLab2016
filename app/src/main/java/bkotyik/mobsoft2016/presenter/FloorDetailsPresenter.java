package bkotyik.mobsoft2016.presenter;


import javax.inject.Inject;

import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.view.FloorDetailsView;

public class FloorDetailsPresenter extends Presenter<FloorDetailsView> {
    @Inject
    public FloorInteractor floorInteractor;
    @Inject
    public EmployeeInteractor employeeInteractor;

    public FloorDetailsPresenter() {

    }

    public void loadFloor(int _id) {
        try {
            view.showFloorDetails(floorInteractor.getFloorFromNetwork(_id));
        } catch (Exception e) {
            view.showFloorDetails(floorInteractor.getFloorFromDb(_id));
            view.showMessage(e.getMessage());
        }
    }
    public void deleteFloor() {}
    public void editFloor() {}
}
