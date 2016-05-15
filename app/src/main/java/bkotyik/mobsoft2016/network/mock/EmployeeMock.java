package bkotyik.mobsoft2016.network.mock;

import android.net.Uri;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.NewEmployee;
import bkotyik.mobsoft2016.network.GsonHelper;
import bkotyik.mobsoft2016.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EmployeeMock {
    static List<Employee> employeesList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Employee testE1 = new Employee("Network Test 1");
    public static Employee testE2 = new Employee("Network Test 2");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "employees") && request.method().equals("GET")) {
            if (!isInitialised) {
                employeesList.add(testE1);
                employeesList.add(testE2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(employeesList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "employees") && request.method().equals("POST")) {

            Employee employeeToAdd = new Employee();
            employeeToAdd.setName("Mock Employee");
            employeesList.add(employeeToAdd);

            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        employeesList.clear();
        isInitialised = false;
    }
}
