package bkotyik.mobsoft2016.interactor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewEmployee;
import bkotyik.mobsoft2016.model.full.EmployeeDbModel;
import bkotyik.mobsoft2016.network.EmployeesApi;
import bkotyik.mobsoft2016.network.FloorsApi;
import retrofit2.Call;
import retrofit2.Response;

public class EmployeeInteractor {
    @Inject
    EmployeeDbModel model;
    @Inject
    EmployeesApi api;
    @Inject
    FloorsApi fapi;


    private List<Employee> employees;

    public EmployeeInteractor() {
        IndoorMapApplication.injector.inject(this);
    }


    public void addEmployeeToDb(Employee toAdd) {
        model.insert(toAdd);
    }

    public void addEmployeeToNetwork(NewEmployee toAdd) throws Exception {
        Response response = null;

        Call call = api.employeesPost(toAdd);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public List<Employee> getEmployeesFromDb() {
        return model.fetch();
    }

    public List<Employee> getEmployeesFromNetwork() throws Exception {
        Response<List<Employee>> response = null;

        Call<List<Employee>> call = api.employeesGet(null);
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

    public List<Employee> getEmployeesByFloorIdFromDb(long id) {
        return model.fetchByFloorId(id);
    }

    public List<Employee> getEmployeesByFloorIdFromNetwork(long id) throws Exception {
        Response<List<Employee>> response = null;

        Call<List<Employee>> call = fapi.floorsIdEmployeesGet(new BigDecimal(id));
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

    public List<Employee> getEmployeesByNameFromNetwork(String name) throws Exception {
        Response<List<Employee>> response = null;

        Call<List<Employee>> call = api.employeesGet(name);
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

    public List<Employee> getEmployeesByNameFromDb(String name) {
        return model.fetchByEmployeeName(name);
    }
}