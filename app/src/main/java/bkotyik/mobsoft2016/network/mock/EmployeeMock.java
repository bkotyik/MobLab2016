package bkotyik.mobsoft2016.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.network.GsonHelper;
import bkotyik.mobsoft2016.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
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

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "employee") && request.method().equals("GET")) {
            if (!isInitialised) {
                employeesList.add(testE1);
                employeesList.add(testE2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(employeesList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "employees/add") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            String name = uri.getPath().substring(startOfData + 1);
            employeesList.add(new Employee(name));

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
