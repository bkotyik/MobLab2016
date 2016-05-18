package bkotyik.mobsoft2016.model.full;

import java.util.List;

import bkotyik.mobsoft2016.model.Employee;

public class EmployeeDbModel {

    public List<Employee> fetch() {
        List<Employee> values = Employee.listAll(Employee.class);
        return values;
    }

    public void insert(Employee toInsert) {
        toInsert.save();
    }

    public List<Employee> fetchByFloorId(long id) {
        //TODO: Check why this doesnt work
        return Employee.find(Employee.class,"floorId = ?", Long.toString(id));
    }

    public List<Employee> fetchByEmployeeName(String name) {
        return Employee.find(Employee.class,"name = ?", name);
    }
}
