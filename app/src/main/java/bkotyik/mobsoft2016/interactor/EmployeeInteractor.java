package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.EmployeeModel;
import bkotyik.mobsoft2016.model.FloorModel;

public class EmployeeInteractor {
    @Inject
    EmployeeModel model;

    private List<EmployeeModel> employees;

    public EmployeeInteractor() {
        IndoorMapApplication.injector.inject(this);
        this.employees = new ArrayList<EmployeeModel>();
    }

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public EmployeeModel getEmployee(int i) {
        return this.employees.get(i);
    }
}