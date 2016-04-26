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
}
