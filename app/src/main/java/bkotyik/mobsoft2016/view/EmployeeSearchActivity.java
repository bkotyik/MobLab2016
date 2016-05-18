package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.adapters.EmployeeListAdapter;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.presenter.EmployeeSearchPresenter;

public class EmployeeSearchActivity extends Fragment implements EmployeeSearchView {

    @Inject
    EmployeeSearchPresenter employeeSearchPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IndoorMapApplication.injector.inject(this);

        return inflater.inflate(R.layout.activity_employee_search, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        employeeSearchPresenter.attachView(this);

        final EditText etEmployeeSearch = (EditText)getView().findViewById(R.id.etEmployeeName);
        etEmployeeSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                employeeSearchPresenter.searchEmployee(etEmployeeSearch.getText().toString());
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        employeeSearchPresenter.detachView();
    }

    @Override
    public void showSearchResult(List<Employee> employeeList) {
        ListView lvEmployeesSearchResult = (ListView)getView().findViewById(R.id.lvEmployeeSearchResult);
        EmployeeListAdapter adapter = new EmployeeListAdapter(getContext(), employeeList);

        lvEmployeesSearchResult.setAdapter(adapter);
    }
}
