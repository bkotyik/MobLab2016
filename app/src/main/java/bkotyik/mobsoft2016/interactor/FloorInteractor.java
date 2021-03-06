package bkotyik.mobsoft2016.interactor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewFloor;
import bkotyik.mobsoft2016.model.full.EmployeeDbModel;
import bkotyik.mobsoft2016.model.full.FloorDbModel;
import bkotyik.mobsoft2016.network.FloorsApi;
import retrofit2.Call;
import retrofit2.Response;

public class FloorInteractor {
    @Inject
    FloorDbModel model;
    @Inject
    FloorsApi api;
    @Inject
    EmployeeDbModel employeeModel;

    private List<Floor> employees;

    public FloorInteractor() {
        IndoorMapApplication.injector.inject(this);
    }


    public void addEmployeeToDb(Floor toAdd) {
        model.insert(toAdd);
    }

    public void addFloorToNetwork(NewFloor toAdd) throws Exception {
        Response response = null;

        Call call = api.floorsPost(toAdd);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public List<Floor> getFloorsFromDb() {
        return model.fetch();
    }

    public List<Floor> getFloorsFromNetwork() throws Exception {
        Response<List<Floor>> response = null;

        Call<List<Floor>> call = api.floorsGet();
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }

    public Floor getFloorFromNetwork(long id) throws Exception {
        Response<Floor> response = null;
        Call<Floor> call = api.floorsIdGet(BigDecimal.valueOf(id));
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }

    public Floor getFloorFromDb(long id) {
        return model.fetchById(id);
    }

    public void removeFloorFromDb(Long id) {
        model.removeById(id);
    }

    public void removeFloorFromNetwork(Long id) throws Exception {
        Response<Void> response = null;
        Call<Void> call = api.floorsIdDelete(BigDecimal.valueOf(id));
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }
    }

    public void updateFloorToDb(Floor floor) {
        model.update(floor);
    }

    public void updateFloorToNetwork(Floor floor) throws Exception {
        Response response = null;

        Call call = api.floorsIdPut(new BigDecimal(floor.getId()), new NewFloor(floor.getName(),floor.getDescription()));
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public void addFloorToDb(NewFloor newFloor) {
        Floor f = new Floor(newFloor.getName(), newFloor.getDescription());
        model.insert(f);
    }

    public void setEmployeesToFloorNetwork(Long id, List<Employee> employeeList) throws Exception {
        Response response = null;

        Call call = api.floorsIdEmployeesPut(new BigDecimal(id), employeeList);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public void setEmployeesToFloorDb(Long id, List<Employee> employeeList) {
        employeeModel.removeByFloorId(id);
        for (Employee e: employeeList) {
            employeeModel.insert(e);
        }
    }
}