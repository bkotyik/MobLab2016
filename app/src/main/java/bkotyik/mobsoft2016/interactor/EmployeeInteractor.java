package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.full.EmployeeDbModel;
import bkotyik.mobsoft2016.network.EmployeesApi;
import okhttp3.Call;
import okhttp3.Response;

public class EmployeeInteractor {
    @Inject
    EmployeeDbModel model;
    @Inject
    EmployeesApi api;

    private List<Employee> employees;

    public EmployeeInteractor() {
        IndoorMapApplication.injector.inject(this);
    }


    public void addPersonToDb(Employee toAdd) {
        model.inserEmployee(toAdd);
    }

    public void addPersonToNetwork(Employee toAdd) throws Exception {
        Response response = null;

        Call call = api.peopleAddDataGet(toAdd.getName());
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }

    public List<Employee> getPeopleFromDb() {
        return model.fetchPeople();
    }

    public List<Employee> getPeopleFromNetwork() throws Exception {
        Response<List<Employee>> response = null;

        Call<List<Employee>> call = api.peopleGet();
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
}