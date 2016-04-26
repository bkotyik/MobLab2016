package bkotyik.mobsoft2016.view;

import java.util.List;

import bkotyik.mobsoft2016.model.EmployeeModel;
import bkotyik.mobsoft2016.model.FloorModel;

public interface FloorDetailsView {
    void showFloorDetails(FloorModel m);
    void showEmployeeList(List<EmployeeModel> employeeModelList);
}
