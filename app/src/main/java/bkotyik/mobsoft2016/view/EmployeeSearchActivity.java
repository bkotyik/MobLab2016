package bkotyik.mobsoft2016.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;
import bkotyik.mobsoft2016.IndoorMapApplication;
import bkotyik.mobsoft2016.R;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.presenter.EmployeeSearchPresenter;

public class EmployeeSearchActivity extends Activity implements EmployeeSearchView {

    @Inject
    EmployeeSearchPresenter employeeSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_search);
        IndoorMapApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        employeeSearchPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        employeeSearchPresenter.detachView();
    }

    @Override
    public void showSearchResult(List<Employee> EmployeeList) {

    }
}
