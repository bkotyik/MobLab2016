package bkotyik.mobsoft2016.network.mock;

import java.io.IOException;

import javax.inject.Singleton;

import bkotyik.mobsoft2016.network.EmployeesApi;
import bkotyik.mobsoft2016.network.FloorsApi;
import bkotyik.mobsoft2016.network.prod.NetworkModule;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        builder.interceptors().add(0, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
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

