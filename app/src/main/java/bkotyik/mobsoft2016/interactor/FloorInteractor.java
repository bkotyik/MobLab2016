package bkotyik.mobsoft2016.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewFloor;
import bkotyik.mobsoft2016.model.full.FloorDbModel;
import bkotyik.mobsoft2016.network.FloorsApi;
import retrofit2.Call;
import retrofit2.Response;

public class FloorInteractor {
    @Inject
    FloorDbModel model;
    @Inject
    FloorsApi api;

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

}