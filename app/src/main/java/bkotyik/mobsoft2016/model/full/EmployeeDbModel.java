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

    public List<Employee> fetchByFloorId(int id) {
        return Employee.find(Employee.class,"floorId = ?", Integer.toString(id));
    }
}
