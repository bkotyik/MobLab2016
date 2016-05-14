package bkotyik.mobsoft2016.unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;
import bkotyik.mobsoft2016.BuildConfig;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.NewEmployee;
import bkotyik.mobsoft2016.network.mock.EmployeeMock;

import static bkotyik.mobsoft2016.TestHelper.setTestInjector;
import static org.junit.Assert.*;

@RunWith(bkotyik.mobsoft2016.RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class EmployeeUnitTest {

    @Inject
    public EmployeeInteractor interactor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        interactor = new EmployeeInteractor();
    }

    @Test
    public void getterTest() throws Exception {
        String name = "lala";
        Employee p = new Employee(name);
        assertEquals(p.getName().equals(name), true);
    }

    @Test
    public void mockGetTest() throws Exception {
        EmployeeMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<Employee> p = interactor.getEmployeesFromNetwork();
            assertEquals(p.get(0).getName(), EmployeeMock.testE1.getName());
            assertEquals(p.get(1).getName(), EmployeeMock.testE2.getName());
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        EmployeeMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            NewEmployee n = new NewEmployee("Dr. Nagyon Dolgozo Arpad");

            interactor.addEmployeeToNetwork(n);

            List<Employee> p = interactor.getEmployeesFromNetwork();
            assertEquals(p.get(1).getName(), EmployeeMock.testE1.getName());
            assertEquals(p.get(2).getName(), EmployeeMock.testE2.getName());
            assertEquals(p.get(0).getName(), n.getName());

        }
    }
}