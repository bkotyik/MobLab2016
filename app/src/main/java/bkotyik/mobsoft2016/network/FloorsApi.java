package bkotyik.mobsoft2016.network;


import bkotyik.mobsoft2016.model.Employee;
import bkotyik.mobsoft2016.model.Floor;
import bkotyik.mobsoft2016.model.NewFloor;
import retrofit2.Call;
import retrofit2.http.*;
import okhttp3.RequestBody;
import java.math.BigDecimal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FloorsApi {
  
  /**
   * Visszaadja az adott azonositoja munkatarsat
   * Lehetoseget ad az adott azonositoja munkatars adatainak lekerdezesere.\nA valaszban visszater a munkatars nevevel, szobaszamaval es emeletenek azonosatojaval
   * @param id Munkatars azonositoja.
   * @return Call<Void>
   */
  
  @GET("employees/{id}")
  Call<Void> employeesIdGet(
    @Path("id") BigDecimal id
  );

  
  /**
   * A rendszerben tarolt emeletek listazasa
   * A rendszer emeleteket tarol nevvel es tomor leirassal
   * @return Call<List<Floor>>
   */
  
  @GET("floors")
  Call<List<Floor>> floorsGet();
    

  
  /**
   * Uj emelet hozzaadasa
   * uj emeletet ad hozza a rendszer nyilvantartasahoz
   * @param floor A letrehozando emelet.
   * @return Call<Void>
   */
  
  @POST("floors")
  Call<Void> floorsPost(
    @Body NewFloor floor
  );

  
  /**
   * Visszaadja az adott azonositoja emeletet
   * Lehetoseget ad az adott azonositoju emelet adatainak lekerdezesere.\nA valaszban visszater az emelet nevevel, leirasaval es azonositojaval.
   * @param id Emelet azonositoja.
   * @return Call<Void>
   */
  
  @GET("floors/{id}")
  Call<Floor> floorsIdGet(
    @Path("id") BigDecimal id
  );

  
  /**
   * Frissiti az adott azonositoju emelet adatait a bekuldot adatok alapjan
   * Lehetoseget ad egy emelet adatainak frissitesere
   * @param id Emelet azonositoja.
   * @param floor A modositott emelet entitas
   * @return Call<Void>
   */
  
  @PUT("floors/{id}")
  Call<Void> floorsIdPut(
    @Path("id") BigDecimal id, @Body NewFloor floor
  );

  
  /**
   * Torli az adott azonositoja emeletet
   * Lehetoseget ad egy emelet torlesere azonosito alapjan
   * @param id Emelet azonositoja.
   * @return Call<Void>
   */
  
  @DELETE("floors/{id}")
  Call<Void> floorsIdDelete(
    @Path("id") BigDecimal id
  );

  
  /**
   * Visszaadja az adott azonositoja emeleten dolgozo munkatarsakat
   * Az az egyes szinteken munkatarsak dolgoznak. A vegpont lehetoseget ad egy adott szinten dolgozo munkatarsak listajanak lekerdezesere.
   * @param id Emelet azonos�t�ja.
   * @return Call<List<Employee>>
   */
  
  @GET("floors/{id}/employees")
  Call<List<Employee>> floorsIdEmployeesGet(
    @Path("id") BigDecimal id
  );

  @PUT("floors/{id}/employees")
  Call<Void> floorsIdEmployeesPut(
          @Path("id") BigDecimal id,
          @Body List<Employee> employees
  );


  
}
