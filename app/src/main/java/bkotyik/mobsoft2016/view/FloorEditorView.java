package bkotyik.mobsoft2016.view;


import java.util.List;

import bkotyik.mobsoft2016.model.EmployeeModel;
import bkotyik.mobsoft2016.model.FloorModel;

public interface FloorEditorView {
    void showFloorDetails(FloorModel floorModel);
    void showEmployees(List<EmployeeModel> employeeModels);
    void showMessage(String msg);
}
