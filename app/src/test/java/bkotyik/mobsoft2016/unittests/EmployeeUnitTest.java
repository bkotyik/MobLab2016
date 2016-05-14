package bkotyik.mobsoft2016.unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import javax.inject.Inject;
import bkotyik.mobsoft2016.BuildConfig;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.model.Employee;
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
            /*
            List<Employee> p = interactor.getPeopleFromNetwork();
            assertEquals(p.get(0).getName(), PeopleMock.testP1.getName());
            assertEquals(p.get(1).getName(), PeopleMock.testP2.getName());
            */
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        EmployeeMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            Employee n = new Employee("Dr. Nagyon Dolgozo Arpad");
            /*
            interactor.addPersonToNetwork(n);

            List<Person> p = interactor.getPeopleFromNetwork();
            assertEquals(p.get(1).getName(), PeopleMock.testP1.getName());
            assertEquals(p.get(2).getName(), PeopleMock.testP2.getName());
            assertEquals(p.get(0).getName(), n.getName());
            */
        }
    }
}