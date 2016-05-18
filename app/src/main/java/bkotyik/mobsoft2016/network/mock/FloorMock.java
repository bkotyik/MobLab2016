package bkotyik.mobsoft2016.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewEmployee;
import bkotyik.mobsoft2016.model.NewFloor;
import bkotyik.mobsoft2016.network.GsonHelper;
import bkotyik.mobsoft2016.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class FloorMock {
    static List<Floor> floorsList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Floor testF1 = new Floor(1, "Floor 1", "Description 1");
    public static Floor testF2 = new Floor(2, "Floor 2", "Description 2");
    public static Floor testF3 = new Floor(3, "Floor 3", "Description 3");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode = 400;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "floors") && request.method().equals("GET")) {
            if (!isInitialised) {
                floorsList.add(testF1);
                floorsList.add(testF2);
                floorsList.add(testF3);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(floorsList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "floors") && request.method().equals("POST")) {

            final Buffer buffer = new Buffer();
            RequestBody body = request.body();
            String jsonString = null;

            try {
                body.writeTo(buffer);
                jsonString = buffer.readUtf8();
            }
            catch (Exception ex) {

            }

            if (jsonString != null) {
                NewFloor floor = GsonHelper.getGson().fromJson(jsonString, NewFloor.class);

                Floor floorToAdd = new Floor(floorsList.size(), floor.getName(), floor.getDescription());
                floorsList.add(floorToAdd);

                responseString = "";
                responseCode = 200;
            }

        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "floors/") && request.method().equals("GET")) {
            List<String> path = request.url().pathSegments();
            if (path.size() == 2) {
                // floors/{id}
                int id = Integer.parseInt(path.get(1));
                Floor requestedFloor = floorsList.get(id - 1);
                responseString = GsonHelper.getGson().toJson(requestedFloor);
                responseCode = 200;
            } else if (path.size() == 3) {
                // floors/{id}/employees
                int floorId = Integer.parseInt(path.get(1));
                List<Employee> workersOnFloor = new ArrayList<>();

                for (Employee e: EmployeeMock.getMockEmployees()) {
                    if (e.getFloorId() == floorId) {
                        workersOnFloor.add(e);
                    }
                }
                responseString = GsonHelper.getGson().toJson(workersOnFloor);
                responseCode = 200;

            }
        }
        else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        floorsList.clear();
        isInitialised = false;
    }
}
