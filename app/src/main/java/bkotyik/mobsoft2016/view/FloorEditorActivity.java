package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.EmployeeListAdapter;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.presenter.FloorEditorPresenter;

public class FloorEditorActivity extends Activity implements FloorEditorView {

    @Inject
    FloorEditorPresenter floorEditorPresenter;
    Button btnAddFloor = null;
    Button btnAddEmployee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_editor);
        IndoorMapApplication.injector.inject(this);

        btnAddFloor = (Button)findViewById(R.id.btnAddFloor);
        btnAddFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editFloorName = (EditText)findViewById(R.id.editFloorName);
                EditText editFloorDescription = (EditText)findViewById(R.id.editFloorDescription);

                floorEditorPresenter.saveFloorChanges(editFloorName.getText().toString(), editFloorDescription.getText().toString());
            }
        });
        btnAddEmployee = (Button)findViewById(R.id.btnAddEmployee);
        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editEmployeeName = (EditText)findViewById(R.id.editEmployeeName);
                EditText editEmployeeRoomNumber = (EditText)findViewById(R.id.editEmployeeRoomNumber);

                floorEditorPresenter.addEmployee(editEmployeeName.getText().toString(),editEmployeeRoomNumber.getText().toString());
                editEmployeeName.setText("");
                editEmployeeRoomNumber.setText("");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        floorEditorPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        floorEditorPresenter.detachView();
    }

    @Override
    public void showFloorDetails(Floor Floor) {

    }

    @Override
    public void showEmployees(List<Employee> employeeList) {
        ListView lvEmployees = (ListView)findViewById(R.id.employeesListView);
        lvEmployees.setAdapter(new EmployeeListAdapter(getApplicationContext(),employeeList));
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
