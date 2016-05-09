package bkotyik.mobsoft2016.network.prod;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.network.EmployeesApi;
import bkotyik.mobsoft2016.network.FloorsApi;
import bkotyik.mobsoft2016.network.GsonHelper;
import bkotyik.mobsoft2016.network.NetworkConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder clientBuilder = null;
        try {
            clientBuilder = UnsafeClientFactory.getUnsafeClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (clientBuilder == null) {
            throw new RuntimeException("HttpClient cannot be initialized!");
        }

        return clientBuilder;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public EmployeesApi provideEmployeesApi(Retrofit retrofit) {
        return retrofit.create(EmployeesApi.class);
    }

    @Provides
    @Singleton
    public FloorsApi provideFloorsApi(Retrofit retrofit) {
        return retrofit.create(FloorsApi.class);
    }

}