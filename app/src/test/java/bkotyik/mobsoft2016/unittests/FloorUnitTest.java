package bkotyik.mobsoft2016.unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkotyik.mobsoft2016.BuildConfig;
import bkotyik.mobsoft2016.interactor.EmployeeInteractor;
import bkotyik.mobsoft2016.interactor.FloorInteractor;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewEmployee;
import bkotyik.mobsoft2016.model.NewFloor;
import bkotyik.mobsoft2016.network.mock.EmployeeMock;
import bkotyik.mobsoft2016.network.mock.FloorMock;

import static bkotyik.mobsoft2016.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;

@RunWith(bkotyik.mobsoft2016.RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class FloorUnitTest {

    @Inject
    public FloorInteractor interactor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        interactor = new FloorInteractor();
    }

    @Test
    public void mockGetTest() throws Exception {
        FloorMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<Floor> p = interactor.getFloorsFromNetwork();
            assertEquals(p.get(0).getName(), FloorMock.testF1.getName());
            assertEquals(p.get(1).getName(), FloorMock.testF2.getName());
        }
    }

    public void mockGetByNameTest() throws Exception {
        FloorMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            interactor.removeFloorFromNetwork((long)1);
            List<Floor> p = interactor.getFloorsFromNetwork();
            assertEquals(p.get(0).getName(), FloorMock.testF2.getName());
            assertEquals(p.size(), 1);
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        FloorMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            NewFloor n = new NewFloor("test","test");

            interactor.addFloorToNetwork(n);

            List<Floor> p = interactor.getFloorsFromNetwork();
            assertEquals(p.get(0).getName(), FloorMock.testF1.getName());
            assertEquals(p.get(1).getName(), FloorMock.testF2.getName());
            assertEquals(p.get(2).getName(), FloorMock.testF3.getName());
            assertEquals(p.get(3).getName(), n.getName());
        }
    }

    @Test
    public void mockGetFloorByIdTest() throws Exception {
        FloorMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {

            Floor p = interactor.getFloorFromNetwork(1);
            assertEquals(p.getName(), FloorMock.testF1.getName());
        }
    }

    @Test
    public void mockDeleteFloorByIdTest() throws Exception {
        FloorMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {

            interactor.removeFloorFromNetwork((long)1);
            List<Floor> p = interactor.getFloorsFromNetwork();
            assertEquals(p.get(0).getName(), FloorMock.testF2.getName());
            assertEquals(p.get(1).getName(), FloorMock.testF3.getName());
            assertEquals(2, p.size());
        }
    }


}