package bkotyik.mobsoft2016.view;

import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;

public interface FloorDetailsView {
    void showFloorDetails(Floor m);
    void showEmployeeList(List<Employee> EmployeeList);
}
