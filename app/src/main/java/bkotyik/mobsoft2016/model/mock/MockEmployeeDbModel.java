package bkotyik.mobsoft2016.model.mock;

import java.util.LinkedList;
import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.full.EmployeeDbModel;

public class MockEmployeeDbModel extends EmployeeDbModel {

    LinkedList<Employee> values = new LinkedList<>();

    public MockEmployeeDbModel() {
        values.add(new Employee("E1"));
        values.add(new Employee("E2"));
    }

    @Override
    public List<Employee> fetch() {
        return values;
    }

    @Override
    public void insert(Employee toInsert) {
        values.add(toInsert);
    }

}
