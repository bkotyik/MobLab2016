package bkotyik.mobsoft2016.presenter;

import android.widget.Toast;

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
    private boolean isNewFloor = false;

    public FloorEditorPresenter() {
        currentFloor = new Floor("");
        employeeList = new ArrayList<Employee>();
        IndoorMapApplication.injector.inject(this);
    }


    public void addEmployee(String name, String roomNumber) {
        employeeList.add(new Employee(name, roomNumber, currentFloor.getId().intValue()));
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
        view.onSaveChanged();
    }

    public void loadFloor(long id) {
        if (id == -1 ) {
            isNewFloor = true;
            employeeList = new ArrayList<>();
            view.showEmployees(employeeList);
        } else  {
            isNewFloor = false;
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
    }

    public void removeEmployee(int id) {
        employeeList.remove(id);
    }

    public void saveEmployees(List<Employee> employees) {
        if (currentFloor.getId() != null) {
            try {
                floorInteractor.setEmployeesToFloorNetwork(currentFloor.getId(), employeeList);
            }
            catch (Exception e) {
                floorInteractor.setEmployeesToFloorDb(currentFloor.getId(), employeeList);
                view.showMessage(e.getMessage());
            }
        }
    }

    public boolean isNewFloor() {
        return isNewFloor;
    }
}
