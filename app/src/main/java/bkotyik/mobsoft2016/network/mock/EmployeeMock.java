package bkotyik.mobsoft2016.network.mock;

import android.net.Uri;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
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
import okio.Buffer;

public class EmployeeMock {
    static List<Employee> employeesList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Employee testE1 = new Employee("Employee 1", "Room 1",1);
    public static Employee testE2 = new Employee("Employee 2", "Room 2",2);
    public static Employee testE3 = new Employee("Employee 3", "Room 3",3);

    public static List<Employee> getMockEmployees() {
        if (!isInitialised) {
            employeesList.add(testE1);
            employeesList.add(testE2);
            employeesList.add(testE3);
            isInitialised = true;
        }
        return employeesList;
    }

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode = 400;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "employees") && request.method().equals("GET")) {
            getMockEmployees();

            if (request.url().queryParameter("name") == null) {
                responseString = GsonHelper.getGson().toJson(employeesList);
            } else {
                String name = request.url().queryParameter("name");

                List<Employee> filtered = new ArrayList<Employee>();
                for (Employee e: employeesList) {
                    if (e.getName().contains(name)) {
                        filtered.add(e);
                    }
                }
                responseString = GsonHelper.getGson().toJson(filtered);
            }
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "employees") && request.method().equals("POST")) {

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
                NewEmployee employee = GsonHelper.getGson().fromJson(jsonString, NewEmployee.class);

                Employee employeeToAdd = new Employee();
                employeeToAdd.setName(employee.getName());
                employeeToAdd.setRoomNumber(employee.getRoomNumber());
                employeesList.add(employeeToAdd);

                responseString = "";
                responseCode = 200;
            }

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
