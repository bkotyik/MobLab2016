package bkotyik.mobsoft2016.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.view.EmployeeSearchView;

public class EmployeeSearchPresenter extends Presenter<EmployeeSearchView> {
    @Inject
    EmployeeInteractor employeeInteractor;

    public  EmployeeSearchPresenter() {
        IndoorMapApplication.injector.inject(this);
    }

    public void searchEmployee(String name) {
        List<Employee> result = new ArrayList<Employee>();
        try {
            result = employeeInteractor.getEmployeesByNameFromNetwork(name);
        }
        catch (Exception e) {
            result = employeeInteractor.getEmployeesByNameFromDb(name);
        }
        view.showSearchResult(result);
    }

}
