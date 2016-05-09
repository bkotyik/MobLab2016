package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;

public class EmployeeInteractor {
    @Inject
    Employee model;

    private List<Employee> employees;

    public EmployeeInteractor() {
        IndoorMapApplication.injector.inject(this);
        this.employees = new ArrayList<Employee>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int i) {
        return this.employees.get(i);
    }
}