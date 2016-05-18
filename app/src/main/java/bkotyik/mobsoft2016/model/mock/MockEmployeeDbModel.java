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


    public List<Employee> fetchByFloorId(int id) {
        LinkedList<Employee> v = new LinkedList<>();
        for (Employee e: values) {
            if (e.getFloorId() == (int)(long)id) {
                v.add(e);
            }
        }
        return v;
    }

    public List<Employee> fetchByEmployeeName(String name) {
        LinkedList<Employee> v = new LinkedList<>();
        for (Employee e: values) {
            if (e.getName().equals(name)) {
                v.add(e);
            }
        }
        return v;
    }

    public void removeByFloorId(Long id) {
        LinkedList<Employee> v = new LinkedList<>();
        for (Employee e: values) {
            if (e.getFloorId() != (int)(long)id) {
                v.add(e);
            }
        }
        values = v;
    }

}


