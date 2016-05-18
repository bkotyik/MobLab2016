package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class FloorEditorActivity extends Fragment implements FloorEditorView {

    @Inject
    FloorEditorPresenter floorEditorPresenter;
    Button btnAddFloor = null;
    Button btnAddEmployee = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IndoorMapApplication.injector.inject(this);

        return inflater.inflate(R.layout.activity_floor_editor, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        floorEditorPresenter.attachView(this);

        btnAddFloor = (Button)getView().findViewById(R.id.btnAddFloor);
        btnAddFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editFloorName = (EditText)getView().findViewById(R.id.editFloorName);
                EditText editFloorDescription = (EditText)getView().findViewById(R.id.editFloorDescription);

                floorEditorPresenter.saveFloorChanges(editFloorName.getText().toString(), editFloorDescription.getText().toString());
            }
        });
        btnAddEmployee = (Button)getView().findViewById(R.id.btnAddEmployee);
        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editEmployeeName = (EditText)getView().findViewById(R.id.editEmployeeName);
                EditText editEmployeeRoomNumber = (EditText)getView().findViewById(R.id.editEmployeeRoomNumber);

                floorEditorPresenter.addEmployee(editEmployeeName.getText().toString(),editEmployeeRoomNumber.getText().toString());
                editEmployeeName.setText("");
                editEmployeeRoomNumber.setText("");
            }
        });

        Bundle args = getArguments();
        floorEditorPresenter.loadFloor(args.getLong("FLOOR_ID", 0));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        floorEditorPresenter.detachView();
    }

    @Override
    public void showFloorDetails(Floor floor) {
        EditText editTextFloorName = (EditText)getView().findViewById(R.id.editFloorName);
        EditText editTextFloorDescription = (EditText)getView().findViewById(R.id.editFloorDescription);

        editTextFloorName.setText(floor.getName());
        editTextFloorDescription.setText(floor.getDescription());
    }

    @Override
    public void showEmployees(List<Employee> employeeList) {
        ListView lvEmployees = (ListView)getView().findViewById(R.id.employeesListView);
        lvEmployees.setAdapter(new EmployeeListAdapter(getContext(),employeeList));
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }
}
