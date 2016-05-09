package bkotyik.mobsoft2016.view;


import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;

public interface FloorEditorView {
    void showFloorDetails(Floor Floor);
    void showEmployees(List<Employee> Employees);
    void showMessage(String msg);
}
