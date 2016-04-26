package bkotyik.mobsoft2016.presenter;

import javax.inject.Inject;

import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.model.EmployeeModel;
import bkotyik.mobsoft2016.view.EmployeeSearchView;

public class EmployeeSearchPresenter extends Presenter<EmployeeSearchView> {
    @Inject
    EmployeeInteractor employeeInteractor;

    public  EmployeeSearchPresenter() {

    }

    public void searchEmployee(String name) {}
    public void selectEmployee(int id) {

    }
}
