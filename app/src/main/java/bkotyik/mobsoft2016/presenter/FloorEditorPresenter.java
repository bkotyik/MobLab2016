package bkotyik.mobsoft2016.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewFloor;
import bkotyik.mobsoft2016.view.FloorEditorView;

public class FloorEditorPresenter extends Presenter<FloorEditorView> {
    @Inject
    public FloorInteractor floorInteractor;
    @Inject
    public EmployeeInteractor employeeInteractor;

    Floor currentFloor;
    List<Employee> employeeList;

    public FloorEditorPresenter() {
        currentFloor = new Floor("");
        employeeList = new ArrayList<Employee>();
        IndoorMapApplication.injector.inject(this);
    }


    public void addEmployee(String name, String roomNumber) {
        employeeList.add(new Employee(name, roomNumber));
        view.showEmployees(employeeList);
    }


    public void saveFloorChanges(String name, String description) {
        currentFloor.setName(name);
        currentFloor.setDescription(description);
        if (currentFloor.getId() == null) {
            // save
            try {
                floorInteractor.addFloorToNetwork(new NewFloor(name,description));
            }
            catch (Exception e) {
                floorInteractor.addFloorToDb(new NewFloor(name,description));
                view.showMessage(e.getMessage());
            }
        } else {
            // update
            try {
                floorInteractor.updateFloorToNetwork(currentFloor);
            }
            catch (Exception e) {
                floorInteractor.updateFloorToDb(currentFloor);
                view.showMessage(e.getMessage());
            }
        }
    }

    public void loadFloor(int id) {
        try {
            currentFloor = floorInteractor.getFloorFromNetwork(id);
        } catch (Exception e) {
            currentFloor = floorInteractor.getFloorFromDb(id);
            view.showMessage(e.getMessage());
        } finally {
            view.showFloorDetails(currentFloor);
        }

        try {
            employeeList = employeeInteractor.getEmployeesByFloorIdFromNetwork(id);
        } catch (Exception e) {
            employeeList = employeeInteractor.getEmployeesByFloorIdFromDb(id);
            view.showMessage(e.getMessage());
        } finally {
          view.showEmployees(employeeList);
        }
    }

    public void removeEmployee(int id) {
        employeeList.remove(id);
    }
}
