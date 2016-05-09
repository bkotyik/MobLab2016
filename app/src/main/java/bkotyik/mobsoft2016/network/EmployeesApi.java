package bkotyik.mobsoft2016.network;
import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.NewEmployee;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeesApi {
  
  /**
   * A rendszerben tarolt munkatarsak listazasa
   * A rendszer eltarolja a munkatarsakat nevvel es szobaszammal. Minden munkatarshoz egy emelet van hozzarendelve ahol a szobaja megtalalhato.
   * @return Call<List<Employee>>
   */
  
  @GET("employees")
  Call<List<Employee>> employeesGet();
    

  
  /**
   * Uj munkatars hozzaadasa
   * Uj munkatars ad hozza a rendszer nyilvantartasahoz
   * @param employee A letrehozando munkatars.
   * @return Call<Void>
   */
  
  @POST("employees")
  Call<Void> employeesPost(
    @Body NewEmployee employee
  );

  
  /**
   * Frissiti az adott azonositoja munkatars adatait a bekuldot adatok alapjan
   * Leheteseget ad egy munkatars adatainak frissitesere
   * @param id Munkatars azonositoja.
   * @param employee A modositott munkatars entitas
   * @return Call<Void>
   */
  
  @PUT("employees/{id}")
  Call<Void> employeesIdPut(
    @Path("id") BigDecimal id, @Body NewEmployee employee
  );

  
  /**
   * Torli az adott azonositoja munkatarsat a rendszerbol
   * Lehetoseget ad egy munkatars torlesere azonosito alapjan
   * @param id Munkatars azonositoja.
   * @return Call<Void>
   */
  
  @DELETE("employees/{id}")
  Call<Void> employeesIdDelete(
    @Path("id") BigDecimal id
  );

  
}
