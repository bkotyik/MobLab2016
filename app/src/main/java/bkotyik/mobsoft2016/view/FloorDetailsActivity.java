package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import bkotyik.mobsoft2016.presenter.FloorDetailsPresenter;
import bkotyik.mobsoft2016.presenter.MainPresenter;

public class FloorDetailsActivity extends Fragment implements FloorDetailsView {
    @Inject
    FloorDetailsPresenter presenter;

    ImageButton btnDeleteFloor = null;
    ImageButton btnEditFloor = null;

    ListView employeeListView = null;
    EmployeeListAdapter listAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IndoorMapApplication.injector.inject(this);

        return inflater.inflate(R.layout.activity_floor_details, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);

        btnDeleteFloor = (ImageButton)getView().findViewById(R.id.btnDeleteFloor);
        btnDeleteFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(v.getContext())
                        .setMessage("Tényleg törlöd az emeletet?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                presenter.deleteFloor();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


            }
        });

        btnEditFloor = (ImageButton)getView().findViewById(R.id.btnEditFloor);
        btnEditFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FloorEditorActivity newFragment = new FloorEditorActivity();
                Bundle args = new Bundle();
                //args.putLong("FLOOR_ID", floor.getId());
                newFragment.setArguments(args);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.flContent, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });


        Bundle bundle = this.getArguments();
        presenter.loadFloor(bundle.getLong("FLOOR_ID",0));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showFloorDetails(Floor m) {
        TextView tvFloorDetails = (TextView)getView().findViewById(R.id.tvFloorDescription);
        tvFloorDetails.setText(m.getDescription());

        TextView tvFloorName = (TextView)getView().findViewById(R.id.tvFloorName);
        tvFloorName.setText(m.getName());

    }

    @Override
    public void showEmployeeList(List<Employee> EmployeeList) {
        employeeListView = (ListView)getView().findViewById(R.id.lvEmployees);
        listAdapter = new EmployeeListAdapter(getContext(),EmployeeList);
        employeeListView.setAdapter( listAdapter );
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
